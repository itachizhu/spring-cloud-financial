package org.itachi.cloud.config;

import org.itachi.cloud.repository.converter.DataPointIdReaderConverter;
import org.itachi.cloud.repository.converter.DataPointIdWriterConverter;
import org.itachi.cloud.service.security.CustomUserInfoTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import java.util.Arrays;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 17:53
 */
@EnableResourceServer
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class ResourceServerConfig {
    @Autowired
    private ResourceServerProperties sso;

    @Bean
    public ResourceServerTokenServices tokenServices() {
        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }

    @Configuration
    static class CustomConversionsConfig {
        @Bean
        public CustomConversions customConversions() {
            return new CustomConversions(Arrays.asList(new DataPointIdReaderConverter(),
                    new DataPointIdWriterConverter()));
        }
    }
}
