package org.itachi.cloud.controller;

import org.itachi.cloud.model.User;
import org.itachi.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 17:34
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }
}
