package com.spring.security.service;

import com.spring.security.controller.UserPrinciples;
import com.spring.security.model.LoginRequest;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import com.spring.security.utility.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final JWTUtil jwtUtil;
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;

    public UserService(JWTUtil jwtUtil,
                       UserRepository repository,
                       @Lazy AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.repository = repository;
        this.authenticationManager = authenticationManager;
    }

    public String verifyUser(LoginRequest user) {
        logger.info("Verifying user: {}", user.getUserName());
        Optional<User> existingUser = repository.findByUserName(user.getUserName());
        if (existingUser.isPresent()) {
            logger.debug("User found: {}", user.getUserName());
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            try {
                logger.debug("Attempting authentication for user: {}", user.getUserName());
                Authentication authenticate = authenticationManager.authenticate(authenticationToken);
                if (authenticate.isAuthenticated()) {
                    logger.info("Authentication successful for user: {}", user.getUserName());
                    return jwtUtil.generateToken(new UserPrinciples(existingUser.get()));
                } else {
                    logger.warn("Authentication failed for user: {}", user.getUserName());
                    return "Authentication failed for user: " + user.getUserName();
                }
            } catch (AuthenticationException ex) {
                logger.error("Invalid credentials for user: {}. Exception: {}", user.getUserName(), ex.getMessage());
                return "Invalid credentials: " + ex.getMessage();
            }
        } else {
            logger.warn("User not found: {}", user.getUserName());
            return "User not found with username: " + user.getUserName();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Loading user by username: {}", username);
        User user = repository.findByUserName(username)
                .orElseThrow(() -> {
                    logger.error("User not found with username: {}", username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });
        logger.debug("User loaded: {}", username);
        return new UserPrinciples(user);
    }

    public User registerUser(User user) {
        logger.info("Registering new user: {}", user.getUserName());
        User savedUser = repository.save(user);
        logger.debug("User registered: {}", savedUser.getUserName());
        return savedUser;
    }
}