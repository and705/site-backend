package com.nd705.suppointspb.service.auth;

import com.nd705.suppointspb.entity.user.User;
import com.nd705.suppointspb.model.auth.LoginResponse;
import com.nd705.suppointspb.model.auth.LoginDto;
import com.nd705.suppointspb.model.auth.RegisterDto;

public interface AuthService {
    LoginResponse login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    User findByEmail(String email);

}
