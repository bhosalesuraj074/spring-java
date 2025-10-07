package com.spring.security.controller;

import com.spring.security.model.Roles;
import com.spring.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class UserPrinciples implements UserDetails {
    private static final Logger logger = LoggerFactory.getLogger(UserPrinciples.class);

    private User user;

    public UserPrinciples() {
        logger.info("UserPrinciples default constructor called");
    }

    public UserPrinciples(User user) {
        this.user = user;
        logger.info("UserPrinciples created for user: {}", user != null ? user.getUserName() : "null");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        logger.info("Getting authorities for user: {}", user != null ? user.getUserName() : "null");
        return List.of(new SimpleGrantedAuthority(user.getRoles().toString()));
    }

    @Override
    public String getPassword() {
        logger.info("Getting password for user: {}", user != null ? user.getUserName() : "null");
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        logger.info("Getting username for user: {}", user != null ? user.getUserName() : "null");
        return user.getUserName();
    }
}