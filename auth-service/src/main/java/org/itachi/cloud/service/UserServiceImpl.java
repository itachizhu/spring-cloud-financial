package org.itachi.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.itachi.cloud.model.User;
import org.itachi.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 10:16
 */
@Slf4j
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void create(User user) {
        User existing = repository.findOne(user.getUsername());
        Assert.isNull(existing, "user already exists: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        repository.save(user);

        log.info("new user has been created: {}", user.getUsername());
    }
}
