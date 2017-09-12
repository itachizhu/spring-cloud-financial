package org.itachi.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:55
 */
@FeignClient(name = "account-service")
public interface AccountServiceClient {
    @GetMapping(value = "/accounts/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getAccount(@PathVariable("accountName") String accountName);
}
