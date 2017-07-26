package com.kevin.aop.controller;

import com.kevin.aop.aspect.DataAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户recourse
 *
 * @author Jkevin
 * @create 2017-07-17
 **/
@RestController
public class UserController {

    @DataAuth(perms = {"p1","p2"})
    @GetMapping("users")
    public String getUsers(){

        return "success";
    }
}
