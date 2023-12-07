package com.nd705.springsecuritylesson.controller;

import com.nd705.springsecuritylesson.model.LoginRequest;
import com.nd705.springsecuritylesson.model.LoginResponse;
import com.nd705.springsecuritylesson.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

}
