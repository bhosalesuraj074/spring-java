package com.spring.security.config;

import com.spring.security.utility.JWTFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringConfig {

    private static final Logger logger = LoggerFactory.getLogger(SpringConfig.class);

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTFilter filter;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Configuring SecurityFilterChain");
        http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        request ->
                                request
                                        .requestMatchers("/v1/users/welcome", "/v1/users/login", "/v1/users/register").permitAll()
                                        .anyRequest().authenticated()
                )
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());
        logger.info("SecurityFilterChain configured");
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        logger.info("Creating AuthenticationManager");
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider provider() {
        logger.info("Configuring DaoAuthenticationProvider with UserDetailsService: {}", userDetailsService.getClass().getName());
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        logger.info("DaoAuthenticationProvider configured");
        return provider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        logger.info("Creating BCryptPasswordEncoder");
        return new BCryptPasswordEncoder(12);
    }
}