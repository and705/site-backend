package com.nd705.springsecuritylesson.dao;

import com.nd705.springsecuritylesson.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByEmail(String email);
}
