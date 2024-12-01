package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password, String email) throws Exception {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new Exception("用户名已存在");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new Exception("该邮箱已被使用");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));  // 加密密码
        newUser.setRegistrationDate(new Date());

        return userRepository.save(newUser);
    }
}

