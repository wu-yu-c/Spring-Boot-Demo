package com.example.demo.controller;

import com.example.demo.dto.UserRegistrationRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest request) {
        try {
            // 注册新用户
            User newUser = userService.registerUser(request.getUsername(), request.getPassword(), request.getEmail());
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // 处理错误：用户名或邮箱已存在
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

