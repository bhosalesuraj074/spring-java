package com.spring.security.service;

import com.spring.security.controller.UserPrinciples;
import com.spring.security.model.LoginRequest;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    @Lazy
    AuthenticationManager authenticationManager;

    public String verifyUser(LoginRequest user) {
        Optional<User> existingUser = repository.findByUserName(user.getUserName());
        if (existingUser.isPresent()) {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            if (authenticate.isAuthenticated()) {
                return "User authenticated successfully";
            } else {
                return "Authentication failed for user: " + user.getUserName();
            }
        }
        else {
            return "User not found with username: " + user.getUserName();
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUserName(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
            return new UserPrinciples(user.get());
    }


    // Register new user
    public User registerUser(User user) {
        return  repository.save(user);
    }
}
