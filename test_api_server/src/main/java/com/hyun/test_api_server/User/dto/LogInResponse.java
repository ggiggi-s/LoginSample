package com.hyun.test_api_server.User.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
public class LogInResponse {
    private String username;
    private Collection authorities;
    private String token;

    @Builder
    public LogInResponse(String username, Collection authorities, String token) {
        this.username = username;
        this.authorities = authorities;
        this.token = token;
    }
}
