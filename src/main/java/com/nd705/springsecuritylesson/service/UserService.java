package com.nd705.springsecuritylesson.service;

import com.nd705.springsecuritylesson.Entity.UserEntity;

public interface UserService {
    UserEntity findByEmail(String email);
}
