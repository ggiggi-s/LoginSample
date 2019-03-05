package com.hyun.test_api_server;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @RequestMapping("/{name}")
    public String home(@PathVariable String name) {
        Home foundUser = homeRepository.findByName(name);
        return "Hello, " + foundUser.getName() + "!";
    }
}
