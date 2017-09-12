package org.itachi.cloud.controller;

import org.itachi.cloud.domain.User;
import org.itachi.cloud.model.Account;
import org.itachi.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

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

    @PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
    @GetMapping("/{name}")
    public Account getAccountByName(@PathVariable String name) {
        return accountService.findByName(name);
    }

    @GetMapping("/current")
    public Account getCurrentAccount(Principal principal) {
        return accountService.findByName(principal.getName());
    }

    @PutMapping("/current")
    public void saveCurrentAccount(Principal principal, @Valid @RequestBody Account account) {
        accountService.saveChanges(principal.getName(), account);
    }

    @PostMapping("/")
    public Account createNewAccount(@Valid @RequestBody User user) {
        return accountService.create(user);
    }
}
