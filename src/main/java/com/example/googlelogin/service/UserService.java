package com.example.googlelogin.service;

import com.example.googlelogin.config.jwt.JwtTokenProvider;
import com.example.googlelogin.entity.UserEntity;
import com.example.googlelogin.model.CustomUserDetail;
import com.example.googlelogin.model.auth.request.LoginRequest;
import com.example.googlelogin.model.auth.request.RegisterRequest;
import com.example.googlelogin.model.auth.response.LoginResponse;
import com.example.googlelogin.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    public UserEntity save(RegisterRequest user) {
        UserEntity newUser = UserEntity.builder()
                .username(user.getUsername())
                .password(bCryptPasswordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .build();
        userRepository.save(newUser);
        return newUser;
    }

    public LoginResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByUsername(request.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String jwt = jwtTokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }


}
