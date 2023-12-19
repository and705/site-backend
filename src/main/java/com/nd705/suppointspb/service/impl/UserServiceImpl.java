package com.nd705.suppointspb.service.impl;

import com.nd705.suppointspb.entity.user.Role;
import com.nd705.suppointspb.entity.user.User;
import com.nd705.suppointspb.dao.UserRepository;
import com.nd705.suppointspb.model.LoginSignInDTO;
import com.nd705.suppointspb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    @Override
    public boolean addNewUser(LoginSignInDTO loginSignInDto) {
        if (!Objects.equals(loginSignInDto.getPassword(), loginSignInDto.getMatchingPassword())) {
            throw new RuntimeException("Password is not equals");
        }
        User user = User.builder()
                .email(loginSignInDto.getEmail())
                .password((passwordEncoder.encode(loginSignInDto.getPassword())))
                .role(Role.ROLE_CLIENT)
                .build();
        userRepository.save(user);
        return true;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }


//    private static final String EXISTING_EMAIL = "test@test.com";
//
//    private static final String ANOTHER_EMAIL = "next@test.com";
//
//
//    public Optional<UserEntity> findByEmail(String email) {
//        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
//            var user = new UserEntity();
//            user.setId(1L);
//            user.setEmail(EXISTING_EMAIL);
//            user.setPassword("$2a$12$VS8if.dv0ozlFxjUuK1YTOv5yOphnYcszAa5zcwR70i9SExp2.HYW"); //test
//            user.setRole("ROLE_ADMIN");
//            user.setExtraInfo("My nice Admin");
//            return Optional.of(user);
//
//        } else if (ANOTHER_EMAIL.equalsIgnoreCase(email)) {
//            var user = new UserEntity();
//            user.setId(99L);
//            user.setEmail(ANOTHER_EMAIL);
//            user.setPassword("$2a$12$VS8if.dv0ozlFxjUuK1YTOv5yOphnYcszAa5zcwR70i9SExp2.HYW"); //test
//            user.setRole("ROLE_USER");
//            user.setExtraInfo("My nice User");
//            return Optional.of(user);
//        }
//        return Optional.empty();
//    }
}
