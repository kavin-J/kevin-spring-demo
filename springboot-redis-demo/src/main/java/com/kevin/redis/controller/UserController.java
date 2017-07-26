package com.kevin.redis.controller;

import com.kevin.redis.bean.User;
import com.kevin.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jkevin on 2017/7/16.
 */
@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("users")
    public User findUser(User user) {

        return service.findUser(user);
    }

    @PutMapping("users")
    public User putUser(String idcard,String name) {
        System.err.println("======="+idcard);
        return service.putUser(idcard,name);
    }
}
