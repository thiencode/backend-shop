package com.example.googlelogin.model.auth.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LoginRequest implements Serializable {
    private String username;
    private String password;
}
