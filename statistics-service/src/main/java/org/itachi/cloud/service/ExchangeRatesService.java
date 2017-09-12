package org.itachi.cloud.service;

import org.itachi.cloud.domain.Currency;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 14:43
 */
public interface ExchangeRatesService {
    /**
     * Requests today's foreign exchange rates from a provider
     * or reuses values from the last request (if they are still relevant)
     *
     * @return current date rates
     */
    Map<Currency, BigDecimal> getCurrentRates();

    /**
     * Converts given amount to specified currency
     *
     * @param from {@link Currency}
     * @param to {@link Currency}
     * @param amount to be converted
     * @return converted amount
     */
    BigDecimal convert(Currency from, Currency to, BigDecimal amount);
}
