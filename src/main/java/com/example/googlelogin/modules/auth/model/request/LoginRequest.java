package com.example.googlelogin.modules.auth.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LoginRequest implements Serializable {
    private String username;
    private String password;
}
