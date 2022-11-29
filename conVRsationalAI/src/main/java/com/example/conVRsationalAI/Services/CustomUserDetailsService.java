package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        if(userService.usernameexist(username)){
            UserCredentials user = userService.getUserCredentials(username);
            System.out.println(user.getPassword());
            return User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
        }
        throw new UsernameNotFoundException("User Not Found");
    }
}