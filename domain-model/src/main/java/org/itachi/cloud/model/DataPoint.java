package org.itachi.cloud.model;

import org.itachi.cloud.domain.Currency;
import org.itachi.cloud.domain.timeseries.DataPointId;
import org.itachi.cloud.domain.timeseries.ItemMetric;
import org.itachi.cloud.domain.timeseries.StatisticMetric;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 09:36
 */
@Document(collection = "datapoints")
public class DataPoint {

    @Id
    private DataPointId id;

    private Set<ItemMetric> incomes;

    private Set<ItemMetric> expenses;

    private Map<StatisticMetric, BigDecimal> statistics;

    private Map<Currency, BigDecimal> rates;

    public DataPointId getId() {
        return id;
    }

    public void setId(DataPointId id) {
        this.id = id;
    }

    public Set<ItemMetric> getIncomes() {
        return incomes;
    }

    public void setIncomes(Set<ItemMetric> incomes) {
        this.incomes = incomes;
    }

    public Set<ItemMetric> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<ItemMetric> expenses) {
        this.expenses = expenses;
    }

    public Map<StatisticMetric, BigDecimal> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<StatisticMetric, BigDecimal> statistics) {
        this.statistics = statistics;
    }

    public Map<Currency, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<Currency, BigDecimal> rates) {
        this.rates = rates;
    }
}
