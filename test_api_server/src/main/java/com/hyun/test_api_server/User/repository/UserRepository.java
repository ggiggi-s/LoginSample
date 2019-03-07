package com.hyun.test_api_server.User.repository;

import com.hyun.test_api_server.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByName(String name);
}
