package com.nd705.suppointspb.service.impl;

import com.nd705.suppointspb.entity.user.Role;
import com.nd705.suppointspb.entity.user.User;
import com.nd705.suppointspb.dao.UserRepository;
import com.nd705.suppointspb.exception.ApiException;
import com.nd705.suppointspb.model.auth.LoginResponse;
import com.nd705.suppointspb.model.auth.LoginDto;
import com.nd705.suppointspb.model.auth.RegisterDto;
import com.nd705.suppointspb.security.JwtIssuer;
import com.nd705.suppointspb.security.UserPrincipal;
import com.nd705.suppointspb.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public LoginResponse login(LoginDto loginDto) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();

        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        var token = jwtIssuer.issue(principal.getUserId(), principal.getEmail(), roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();

    }


    @Override
    public String register(RegisterDto registerDto) {
        // add check for username exists in database
        if(userRepository.existsByName(registerDto.getUsername())){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = User.builder()
                .email(registerDto.getEmail())
                .password((passwordEncoder.encode(registerDto.getPassword())))
                .role(Role.ROLE_CLIENT)
                .build();
        userRepository.save(user);

        return "User registered successfully!.";
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
}

