package com.hyun.test_api_server.User.dto;

import lombok.Builder;
import lombok.Setter;

public class LogInResponse {
    private String jSessionID;

    @Builder
    public LogInResponse(String jSessionID) {
        this.jSessionID = jSessionID;
    }
}
