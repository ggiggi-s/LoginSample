package com.hyun.test_api_server.User.controller;

import com.hyun.test_api_server.User.dto.SignUpRequest;
import com.hyun.test_api_server.User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest) {
        userService.createUser(signUpRequest.toUser());
        return new ResponseEntity(HttpStatus.OK);
    }
}
