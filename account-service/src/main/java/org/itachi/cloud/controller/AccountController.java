package org.itachi.cloud.controller;

import org.itachi.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 11:41
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/hello")
    public String hello() {
        return accountService.hello();
    }
}
