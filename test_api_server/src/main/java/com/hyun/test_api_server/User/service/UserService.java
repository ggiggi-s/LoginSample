package com.hyun.test_api_server.User.service;

import com.hyun.test_api_server.User.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService extends UserDetailsService {
    boolean createUser(User user);
    User findUser(String username);
    PasswordEncoder passwordEncoder();
}
