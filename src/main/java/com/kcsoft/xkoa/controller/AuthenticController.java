package com.kcsoft.xkoa.controller;

import com.kcsoft.xkoa.controller.dao.RegisterDao;
import com.kcsoft.xkoa.pojo.User;
import com.kcsoft.xkoa.service.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kcsoft.xkoa.common.UserAuthenticationStatus;

import javax.security.auth.login.FailedLoginException;

@RestController
@RequiredArgsConstructor
public class AuthenticController {
    final UserSecurityService userSecurityService;
    @PostMapping("/user/register")
    public ResponseEntity<String> register(@RequestBody RegisterDao data){
        Long result = userSecurityService.register(data.getUsername(), data.getPassword(), data.getEmail(), data.getPhone());
        if (result == UserAuthenticationStatus.REGISTER_ERROR) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }
    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody RegisterDao data){
        try {
            User user = userSecurityService.passwordAuthentic(data.getUsername(), data.getPassword());
            //TODO 修改成JWT签发
            return new ResponseEntity<>(user.toString(), HttpStatus.OK);
        } catch (FailedLoginException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }
}
