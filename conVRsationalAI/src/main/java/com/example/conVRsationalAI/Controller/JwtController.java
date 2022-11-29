package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.JwtRequest;
import com.example.conVRsationalAI.Services.CustomUserDetailsService;
import com.example.conVRsationalAI.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public String generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println("Entered into body");
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }
        catch (Exception e){
            return "Sorry, Bad Credentials";
        }

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        return this.jwtService.generateToken(userDetails);
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        return "This page only visible when you log in";
    }

}
