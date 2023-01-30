package com.example.googlelogin.modules.auth.controller;

import com.example.googlelogin.controller.BaseController;
import com.example.googlelogin.model.factory.IResponseFactory;
import com.example.googlelogin.model.factory.impl.BaseResponse;
import com.example.googlelogin.modules.auth.entity.UserEntity;
import com.example.googlelogin.modules.auth.model.RandomStuff;
import com.example.googlelogin.modules.auth.model.request.LoginRequest;
import com.example.googlelogin.modules.auth.model.request.RegisterRequest;
import com.example.googlelogin.modules.auth.model.response.LoginResponse;
import com.example.googlelogin.modules.auth.service.UserService;
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
