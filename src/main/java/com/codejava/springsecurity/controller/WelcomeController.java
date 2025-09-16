package com.codejava.springsecurity.controller;

import com.codejava.springsecurity.entity.User;
import com.codejava.springsecurity.service.CustomUserDetailService;
import com.codejava.springsecurity.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    private record Product(Integer id, String name, double price) {}

    @Autowired
    CustomUserDetailService customUserDetailService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        //return "Welcome to Spring Security";
       // return customUserDetailService.verify(user,authenticationManager);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

         if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
         }

        return "User is not Authenticated";
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request) {

        return (CsrfToken) request.getAttribute("_csrf");

    }

    @PostMapping("/products")
    public ResponseEntity<Product> getProducts(@RequestBody Product product) {

        return ResponseEntity.ok().body(product);
    }

}
