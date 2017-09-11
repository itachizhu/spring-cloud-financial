package org.itachi.cloud.service;

import org.itachi.cloud.client.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 11:38
 */
@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AuthServiceClient authClient;

    @Override
    public String hello() {
        return authClient.hello();
    }
}
