package com.example.googlelogin.model.auth.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable {
    private String accessToken;

    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
