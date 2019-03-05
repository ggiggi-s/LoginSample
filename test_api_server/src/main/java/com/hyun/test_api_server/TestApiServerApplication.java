package com.hyun.test_api_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class TestApiServerApplication {
	@GetMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<>();
		model.put("userID", UUID.randomUUID().toString());
		model.put("content", "Hello, World!");
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApiServerApplication.class, args);
	}

}
