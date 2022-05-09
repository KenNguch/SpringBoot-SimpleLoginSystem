package com.kennguch.loginsystem.model;

import lombok.Getter;
import lombok.Setter;

public class JwtResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }

}
