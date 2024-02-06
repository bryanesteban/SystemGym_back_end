package com.bryan.backend.usersapp.backendusersapp.auth.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.bryan.backend.usersapp.backendusersapp.auth.TokenJWTConfig.*;

public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);

    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain)
            throws IOException, ServletException {

                String header = request.getHeader(HEADER_AUTHORIZATION);

                if(header == null || !header.startsWith(PREFIX_TOKEN)){
                    chain.doFilter(request, response);
                    return;
                }
                
        String token = header.replace(PREFIX_TOKEN, "");
        byte[] tokenDecodeBytes = Base64.getDecoder().decode(token);
        String tokenDecode = new String(tokenDecodeBytes);

        String [] tokenArr = tokenDecode.split("\\.");
        String secret = tokenArr[0];
        String username = tokenArr[1];

        try{

            List<GrantedAuthority> Authorities = new ArrayList<>();
            Authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                username,
                null,
                Authorities);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }catch(JwtException e){
            Map<String, String> body = new HashMap<>();
            body.put("error", e.getMessage());
            body.put("message", "El token JWT no es valido!");

            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setStatus(403);
            response.setContentType("application/json");
        }
        


    }
    

}
