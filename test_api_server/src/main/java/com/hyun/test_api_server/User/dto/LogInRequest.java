package com.hyun.test_api_server.User.dto;

import com.hyun.test_api_server.User.entity.User;
import lombok.Getter;

@Getter
public class LogInRequest {
    private String username;
    private String password;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
