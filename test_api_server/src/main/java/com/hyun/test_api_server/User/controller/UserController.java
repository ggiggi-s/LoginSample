package com.hyun.test_api_server.User.controller;

import com.hyun.test_api_server.User.dto.LogInRequest;
import com.hyun.test_api_server.User.dto.LogInResponse;
import com.hyun.test_api_server.User.dto.SignUpRequest;
import com.hyun.test_api_server.User.entity.User;
import com.hyun.test_api_server.User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest) {
        if (userService.createUser(signUpRequest.toUser()) == true) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/{name}")
    public User logIn(@PathVariable String name) {
        User user = userService.findUser(name);
        return user;
    }
}
