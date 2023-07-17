package com.kcsoft.xkoa.controller;

import com.kcsoft.xkoa.controller.dao.RegisterDao;
import com.kcsoft.xkoa.service.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kcsoft.xkoa.common.UserAuthenticationStatus;
@RestController
@RequiredArgsConstructor
public class LoginController {
    final UserSecurityService userSecurityService;
//    @PostMapping("/user/login")
//    public ResponseEntity<String> login(){
//
//    }
    @PostMapping("/user/register")
    public ResponseEntity<String> register(@RequestBody RegisterDao data){
        Long result = userSecurityService.register(data.getUsername(), data.getPassword(), data.getEmail(), data.getPhone());
        if (result == UserAuthenticationStatus.REGISTER_ERROR) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }
}
