package com.kennguch.loginsystem.controller;


import com.kennguch.loginsystem.service.CustomUserDetailService;
import com.kennguch.loginsystem.util.JwtUtil;
import model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<> generateToken(@RequestBody JwtRequest jwtRequest) {

    var userDetails = new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword());
authenticationManager.authenticate(userDetails);


    return ResponseEntity.ok().body("Logged in successfully!");
    }


}
