package org.itachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by itachi on 2017/9/7.
 * User: itachi
 * Date: 2017/9/7
 * Time: 16:16
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistryCenterApplication.class, args);
    }
}
