package org.itachi.cloud.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 09:40
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"date"})
public class ExchangeRatesContainer {

    private LocalDate date = LocalDate.now();

    private Currency base;

    private Map<String, BigDecimal> rates;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Currency getBase() {
        return base;
    }

    public void setBase(Currency base) {
        this.base = base;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "RateList{" +
                "date=" + date +
                ", base=" + base +
                ", rates=" + rates +
                '}';
    }
}
