package com.example.expert.Rest.Security.filter;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.expert.Rest.Security.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String nom = request.getParameter("nom");
        String password = request.getParameter("password");
        System.out.println(nom);
        System.out.println(password);
        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(nom, password);
       
        return authenticationManager.authenticate(authenticationToken);
    } 

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication");
        User user = (User) authResult.getPrincipal();
         Algorithm algorithm=Algorithm.HMAC256(JwtUtil.Mysecret);
         String jwtAccessToken = JWT.create()
         .withSubject(user.getUsername())
         .withExpiresAt(new Date(System.currentTimeMillis()+JwtUtil.Expire_Access_Token))
         .withIssuer(request.getRequestURL().toString())
         .withClaim("roles",user.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList()))
         .sign(algorithm);

         String jwtRefreshToken = JWT.create()
         .withSubject(user.getUsername())
         .withExpiresAt(new Date(System.currentTimeMillis()+15*60*1000))
         .withIssuer(request.getRequestURL().toString())
         .sign(algorithm);
            Map<String,String> idToken = new HashMap<>();
            idToken.put("acces-Token", jwtAccessToken);
            idToken.put("refresh-Token", jwtRefreshToken);
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getOutputStream(),idToken);
    }
    
}
