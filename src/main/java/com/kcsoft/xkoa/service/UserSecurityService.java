package com.kcsoft.xkoa.service;

import com.kcsoft.xkoa.common.UserAuthenticationStatus;
import com.kcsoft.xkoa.pojo.User;
import com.kcsoft.xkoa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode(password);
        User newUser = User.builder()
                .username(username)
                .password(result)
                .email(email)
                .phone(phone)
                .build();
        return userRepository.save(newUser).getId();
    }
    public User passwordAuthentic(String username, String password) throws FailedLoginException {
        Optional<User> user = userRepository.findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (user.isEmpty() || !encoder.matches(password, user.get().getPassword())){
            throw new FailedLoginException();
        }
        return user.get();
    }
}
