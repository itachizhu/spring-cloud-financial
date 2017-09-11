package org.itachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 15:21
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
