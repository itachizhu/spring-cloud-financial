package org.itachi.cloud.service;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.itachi.cloud.domain.Currency;
import org.itachi.cloud.domain.Item;
import org.itachi.cloud.domain.Saving;
import org.itachi.cloud.domain.TimePeriod;
import org.itachi.cloud.domain.timeseries.DataPointId;
import org.itachi.cloud.domain.timeseries.ItemMetric;
import org.itachi.cloud.domain.timeseries.StatisticMetric;
import org.itachi.cloud.model.Account;
import org.itachi.cloud.model.DataPoint;
import org.itachi.cloud.repository.DataPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 14:53
 */
@Slf4j
@Component
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private DataPointRepository repository;

    @Autowired
    private ExchangeRatesService ratesService;

    @Override
    public List<DataPoint> findByAccountName(String accountName) {
        Assert.hasLength(accountName, "[Assertion failed] - [accountName] must not be null or empty");
        return repository.findByIdAccount(accountName);
    }

    @Override
    public DataPoint save(String accountName, Account account) {
        Instant instant = LocalDate.now().atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant();

        DataPointId pointId = new DataPointId(accountName, Date.from(instant));

        Set<ItemMetric> incomes = account.getIncomes().stream()
                .map(this::createItemMetric)
                .collect(Collectors.toSet());

        Set<ItemMetric> expenses = account.getExpenses().stream()
                .map(this::createItemMetric)
                .collect(Collectors.toSet());

        Map<StatisticMetric, BigDecimal> statistics = createStatisticMetrics(incomes, expenses, account.getSaving());

        DataPoint dataPoint = new DataPoint();
        dataPoint.setId(pointId);
        dataPoint.setIncomes(incomes);
        dataPoint.setExpenses(expenses);
        dataPoint.setStatistics(statistics);
        dataPoint.setRates(ratesService.getCurrentRates());

        log.debug("new datapoint has been created: {}", pointId);

        return repository.save(dataPoint);
    }

    private Map<StatisticMetric, BigDecimal> createStatisticMetrics(Set<ItemMetric> incomes, Set<ItemMetric> expenses, Saving saving) {
        BigDecimal savingAmount = ratesService.convert(saving.getCurrency(), Currency.getBase(), saving.getAmount());
        BigDecimal expensesAmount = expenses.stream()
                .map(ItemMetric::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal incomesAmount = incomes.stream()
                .map(ItemMetric::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return ImmutableMap.of(
                StatisticMetric.EXPENSES_AMOUNT, expensesAmount,
                StatisticMetric.INCOMES_AMOUNT, incomesAmount,
                StatisticMetric.SAVING_AMOUNT, savingAmount
        );
    }

    /**
     * Normalizes given item amount to {@link Currency#getBase()} currency with
     * {@link TimePeriod#getBase()} time period
     */
    private ItemMetric createItemMetric(Item item) {
        BigDecimal amount = ratesService
                .convert(item.getCurrency(), Currency.getBase(), item.getAmount())
                .divide(item.getPeriod().getBaseRatio(), 4, RoundingMode.HALF_UP);
        return new ItemMetric(item.getTitle(), amount);
    }
}
