package com.nd705.springsecuritylesson.service;

import com.nd705.springsecuritylesson.Entity.UserEntity;
import com.nd705.springsecuritylesson.dao.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }


//    private static final String EXISTING_EMAIL = "test@test.com";
//
//    private static final String ANOTHER_EMAIL = "next@test.com";
//
//
//    public Optional<UserEntity> findByEmail(String email) {
//        //TODO: move it to database
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
