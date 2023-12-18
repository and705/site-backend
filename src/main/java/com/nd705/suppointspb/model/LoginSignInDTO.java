package com.nd705.suppointspb.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginSignInDTO {
    private String email;
    private String password;
    private String matchingPassword;
}
