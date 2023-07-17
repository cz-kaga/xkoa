package com.kcsoft.xkoa.service;

import com.kcsoft.xkoa.common.UserAuthenticationStatus;
import com.kcsoft.xkoa.pojo.User;
import com.kcsoft.xkoa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService {
    final UserRepository userRepository;
    public Long register(String username, String password, String email, String phone) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            return UserAuthenticationStatus.REGISTER_ERROR;
        }
        User newUser = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .phone(phone)
                .build();
        return userRepository.save(newUser).getId();
    }
}
