package com.spring.security.controller;

import com.spring.security.model.LoginRequest;
import com.spring.security.model.User;
import com.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the User Service!";
    }

    @GetMapping("/info")
    public String userInfo() {
        return "User Info: This is a secured endpoint.";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return  service.verifyUser(loginRequest);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return service.registerUser(user);
    }

}
