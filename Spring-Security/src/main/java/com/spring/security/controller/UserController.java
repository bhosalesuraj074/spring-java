package com.spring.security.controller;

import com.spring.security.model.LoginRequest;
import com.spring.security.model.User;
import com.spring.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserService service;

    @GetMapping("/welcome")
    public String welcome() {
        logger.info("Accessed /welcome endpoint");
        return "Welcome to the User Service!";
    }

    @GetMapping("/info")
    public String userInfo() {
        logger.info("Accessed /info endpoint");
        return "User Info: This is a secured endpoint.";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        logger.info("Login attempt for user: {}", loginRequest.getUserName());
        String result = service.verifyUser(loginRequest);
        logger.info("Login result for user {}: {}", loginRequest.getUserName(), result);
        return result;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        logger.info("Registering new user: {}", user.getUserName());
        user.setPassword(encoder.encode(user.getPassword()));
        User registeredUser = service.registerUser(user);
        logger.info("User registered: {}", registeredUser.getUserName());
        return registeredUser;
    }
}