package com.bryan.backend.usersapp.backendusersapp.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, "/users").permitAll();
    }
}
