package com.example.googlelogin.controller;

import com.example.googlelogin.entity.UserEntity;
import com.example.googlelogin.model.RandomStuff;
import com.example.googlelogin.model.auth.request.LoginRequest;
import com.example.googlelogin.model.auth.request.RegisterRequest;
import com.example.googlelogin.model.auth.response.LoginResponse;
import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.factory.response.IResponseFactory;
import com.example.googlelogin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController extends BaseController {

    protected final UserService userService;

    public AuthController(UserService userService, IResponseFactory iResponseFactory) {
        super(iResponseFactory);
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest req) {
        return iResponseFactory.success(userService.login(req));
    }

    @GetMapping("/random")
    public ResponseEntity<BaseResponse<RandomStuff>> random() {
        return iResponseFactory.success(new RandomStuff("JWT Hợp lệ mới có thể thấy được message này"));
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<UserEntity>> register(@RequestBody RegisterRequest req) {
        return iResponseFactory.success(userService.save(req));
    }
}
