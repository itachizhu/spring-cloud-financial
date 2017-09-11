package org.itachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 10:07
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    /*
    @Configuration
    @EnableWebSecurity
    protected static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private MongoUserDetailsService userDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .csrf()
                    .disable();
            // @formatter:on
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(new BCryptPasswordEncoder());
        }

        @Override
        @Bean("authenticationManager")
        public AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManagerBean();
        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

        private TokenStore tokenStore = new InMemoryTokenStore();

        @Autowired
        @Qualifier("authenticationManager")
        private AuthenticationManager authenticationManager;

        @Autowired
        private MongoUserDetailsService userDetailsService;

        @Autowired
        private Environment env;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            // TODO persist clients details

            // @formatter:off
            clients.inMemory()
                    .withClient("browser")
                    .authorizedGrantTypes("refresh_token", "password")
                    .scopes("ui")
                    .and()
                    .withClient("account-service")
                    .secret(env.getProperty("ACCOUNT_SERVICE_PASSWORD"))
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("server")
                    .and()
                    .withClient("statistics-service")
                    .secret(env.getProperty("STATISTICS_SERVICE_PASSWORD"))
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("server")
                    .and()
                    .withClient("notification-service")
                    .secret(env.getProperty("NOTIFICATION_SERVICE_PASSWORD"))
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("server");
            // @formatter:on
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(tokenStore)
                    .authenticationManager(authenticationManager)
                    .userDetailsService(userDetailsService);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer
                    .tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()");
        }
    }
    */
}
