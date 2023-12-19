package com.nd705.suppointspb.controller.auth;

import com.nd705.suppointspb.model.auth.LoginResponse;
import com.nd705.suppointspb.model.auth.LoginDto;
import com.nd705.suppointspb.service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginDto loginDto){
        return authService.login(loginDto);
    }




}
