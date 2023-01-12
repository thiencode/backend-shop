package com.example.googlelogin.model.auth.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RegisterRequest extends LoginRequest {
    private String email;
}
