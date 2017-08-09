package com.kevin.redis.controller;

import com.kevin.redis.bean.User;
import com.kevin.redis.service.TestService;
import com.kevin.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jkevin on 2017/7/16.
 */
@RestController
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    TestService testService;

    @GetMapping("users")
    public User findUser(User user) {
        return service.findUser(user);
    }
    @GetMapping("list")
    public List<Object> list(User user) {
        return testService.list(user);
    }
    @GetMapping("map")
    public Object map(User user) {
        return testService.map(user);
    }

    @PutMapping("users")
    public User putUser(String idcard,String name) {
        System.err.println("======="+idcard);
        return service.putUser(idcard,name);
    }

    @PostMapping("users:list")
    public void insertList(User user) {
        testService.insertList(user);
    }

    @PostMapping("users:hash")
    public void insertHash(User user) {
        testService.insertMap(user);
    }
}
