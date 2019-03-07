package com.hyun.test_api_server.User.service;

import com.hyun.test_api_server.User.entity.User;
import com.hyun.test_api_server.User.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsername(username);
        return foundUser;
    }

    @Override
    public boolean createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            User createdUser = User.builder()
                    .username(user.getUsername())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .name(user.getName())
                    .build();
            userRepository.save(createdUser);
            return true;
        }
        else return false;
    }

    @Override
    public User findUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}
