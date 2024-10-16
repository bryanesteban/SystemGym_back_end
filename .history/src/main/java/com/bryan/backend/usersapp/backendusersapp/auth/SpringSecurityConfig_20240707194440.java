package com.bryan.backend.usersapp.backendusersapp.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.bryan.backend.usersapp.backendusersapp.auth.filters.JwtAuthenticationFilter;
import com.bryan.backend.usersapp.backendusersapp.auth.filters.JwtValidationFilter;

import jakarta.servlet.FilterRegistration;



@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests()
            
            //Usuarios
            .requestMatchers(HttpMethod.GET, "/users").permitAll()
            .requestMatchers(HttpMethod.GET, "/users/{id}").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, "/users").hasAnyRole( "ADMIN")
            //.requestMatchers("/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/users/{id}").hasAnyRole( "ADMIN")
            .requestMatchers(HttpMethod.PUT, "/users/{id}").hasAnyRole( "ADMIN")
            //Clientes
            .requestMatchers(HttpMethod.GET, "/clients").permitAll()
            .requestMatchers(HttpMethod.GET, "/clients/{identification}").permitAll()
            .requestMatchers(HttpMethod.GET, "/clients/find/{nameValue}").permitAll()
            .requestMatchers(HttpMethod.POST, "/clients").permitAll()
            .requestMatchers(HttpMethod.PUT, "/clients/{identification}").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
            .addFilter(new JwtValidationFilter(authenticationConfiguration.getAuthenticationManager()))
            .csrf(config -> config.disable()) //se deshabilita porque la la logica va en react.
            .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //control de la session
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:5174"));
        config.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "PUT"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);
            return source;
        
    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(
            new CorsFilter(corsConfigurationSource()));
            bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
            return bean;
    }
}
