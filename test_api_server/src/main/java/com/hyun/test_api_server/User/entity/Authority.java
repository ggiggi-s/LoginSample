package com.hyun.test_api_server.User.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authority_id;
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    @Builder
    public Authority(String authority) {
        this.authority = authority;
    }
}
