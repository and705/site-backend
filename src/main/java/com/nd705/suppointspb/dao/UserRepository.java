package com.nd705.suppointspb.dao;

import com.nd705.suppointspb.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByNameOrEmail(String name, String email);

    Optional<User> findByName(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

}
