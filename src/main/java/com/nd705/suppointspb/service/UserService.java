package com.nd705.suppointspb.service;

import com.nd705.suppointspb.Entity.User.User;
import com.nd705.suppointspb.model.LoginSignInDTO;

public interface UserService {
    User findByEmail(String email);
    boolean addNewUser(LoginSignInDTO loginSignInDto);
    void save(User user);
}
