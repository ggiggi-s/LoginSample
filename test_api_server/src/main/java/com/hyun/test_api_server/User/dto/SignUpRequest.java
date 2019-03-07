package com.hyun.test_api_server.User.dto;

import com.hyun.test_api_server.User.entity.Authority;
import com.hyun.test_api_server.User.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class SignUpRequest {
    private String name;
    private String username;
    private String password;

    public User toUser() {
        Collection<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.builder()
                .authority("ROLE_USER")
                .build());

        return User.builder()
                .name(name)
                .username(username)
                .password(password)
                .authorities(authorities)
                .build();

    }
}
