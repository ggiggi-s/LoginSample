package com.hyun.test_api_server;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {
    public Home findByName(String name);
}
