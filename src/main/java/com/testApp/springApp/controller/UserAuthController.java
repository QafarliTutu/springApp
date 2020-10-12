package com.testApp.springApp.controller;


import com.testApp.springApp.payload.request.EmployeeRegisterRequest;
import com.testApp.springApp.payload.request.UserRegisterRequest;
import com.testApp.springApp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/user")
public class UserAuthController {


    private UserService userService;

    public UserAuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<?> UserRegister(@RequestBody UserRegisterRequest regRequest) {
        return userService.UserRegister(regRequest);
    }


}
