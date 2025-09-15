package com.codejava.springsecurity.controller;

import com.codejava.springsecurity.entity.User;
import com.codejava.springsecurity.service.CustomUserDetailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    private record Product(Integer id, String name, double price) {}

    @Autowired
    CustomUserDetailService customUserDetailService;
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        //return "Welcome to Spring Security";
        return customUserDetailService.verify(user,authenticationManager);

    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request) {

        return (CsrfToken) request.getAttribute("_csrf");

    }

    @PostMapping("/products")
    public String welcome(@RequestBody Product product) {

        return "Product is received";

    }

}
