package com.hyun.test_api_server.User.service;

import com.hyun.test_api_server.User.entity.User;
import com.hyun.test_api_server.User.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
