package com.example.googlelogin.modules.auth.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RegisterRequest extends LoginRequest {
    private String email;
}
