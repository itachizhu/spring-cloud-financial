package org.itachi.cloud.client;

import org.itachi.cloud.domain.Currency;
import org.itachi.cloud.domain.ExchangeRatesContainer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 14:46
 */
@FeignClient(url = "${rates.url}", name = "rates-client")
public interface ExchangeRatesClient {
    @GetMapping("/latest")
    ExchangeRatesContainer getRates(@RequestParam("base") Currency base);
}
