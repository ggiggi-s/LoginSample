package com.hyun.test_api_server.User.controller;

import com.hyun.test_api_server.User.dto.LogInRequest;
import com.hyun.test_api_server.User.dto.LogInResponse;
import com.hyun.test_api_server.User.dto.SignUpRequest;
import com.hyun.test_api_server.User.entity.User;
import com.hyun.test_api_server.User.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
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

    @RequestMapping("/login")
    public ResponseEntity<LogInResponse> logIn(@RequestBody LogInRequest logInRequest, HttpSession httpSession) {
        String username = logInRequest.getUsername();
        String password = logInRequest.getPassword();
        log.info("들어옴");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        log.info("들어옴2");

        SecurityContextHolder.getContext().setAuthentication(authentication);
        httpSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        log.info("들어옴3");

        User user = userService.findUser(username);
        log.info(user.toString());
        return new ResponseEntity<>(LogInResponse.builder()
                .username(user.getUsername())
                .authorities(user.getAuthorities())
                .token(httpSession.getId())
                .build(), HttpStatus.OK);
    }
}
