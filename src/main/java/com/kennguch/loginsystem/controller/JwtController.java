package com.kennguch.loginsystem.controller;

import com.kennguch.loginsystem.model.JwtResponse;
import com.kennguch.loginsystem.service.CustomUserDetailService;
import com.kennguch.loginsystem.util.JwtUtil;
import com.kennguch.loginsystem.model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/generateToken")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) {
        //Authorize User
        var authUSer = new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword());
        authenticationManager.authenticate(authUSer);
        var userDetails = customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
        var token = jwtUtil.generateToken(userDetails);
        var jwtResponse = new JwtResponse(token);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }
}
