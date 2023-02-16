package com.example.googlelogin.modules.auth.controller;

import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.factory.response.IResponseFactory;
import com.example.googlelogin.modules.auth.entity.UserEntity;
import com.example.googlelogin.modules.auth.model.RandomStuff;
import com.example.googlelogin.modules.auth.model.request.LoginRequest;
import com.example.googlelogin.modules.auth.model.request.RegisterRequest;
import com.example.googlelogin.modules.auth.model.response.LoginResponse;
import com.example.googlelogin.modules.auth.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    private final UserService userService;

    private final IResponseFactory iResponseFactory;

    public AuthController(UserService userService, IResponseFactory iResponseFactory1) {
        this.userService = userService;
        this.iResponseFactory = iResponseFactory1;
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest req) {
        return iResponseFactory.success(userService.login(req));
    }

    @GetMapping(value = "/random", params = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<RandomStuff>> random() {
        return iResponseFactory.success(new RandomStuff("JWT Hợp lệ mới có thể thấy được message này"));
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<UserEntity>> register(@RequestBody RegisterRequest req) {
        return iResponseFactory.success(userService.save(req));
    }
}
