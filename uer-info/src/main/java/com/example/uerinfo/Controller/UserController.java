package com.example.uerinfo.Controller;

import com.example.uerinfo.entity.User;
import com.example.uerinfo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/get")
    public List<User> get_user() {
       return userMapper.findAll();
    }
}
