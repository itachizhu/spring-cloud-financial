package org.itachi.cloud.client;

import org.itachi.cloud.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 11:31
 */
@FeignClient(name = "auth-service")
public interface AuthServiceClient {
    @PostMapping(value = "/uaa/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(User user);

    @GetMapping("/uaa/users/hello")
    String hello();
}
