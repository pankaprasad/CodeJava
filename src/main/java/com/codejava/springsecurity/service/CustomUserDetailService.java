package com.codejava.springsecurity.service;

import com.codejava.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {

   // @Autowired
   // PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public String getPassword() {
                return new BCryptPasswordEncoder().encode("password");
            }

            @Override
            public String getUsername() {
                return username;
            }
        };

       return userDetails;
    }

   // public String verify(User user, AuthenticationManager  authenticationManager) {
    //   Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

      // if(!authentication.isAuthenticated()) {
       //    return jwtService.generateToken(user.getUsername());
      // }
      // return "Not Authenticated";
    //}
}
