package org.itachi.cloud.service.security;

import org.itachi.cloud.model.User;
import org.itachi.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 10:22
 */
@Component
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findOne(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
