package com.kevin.yml.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kevin.yml.demo.service.UserService;

/**
 * Created by Jkevin on 2017/7/29.
 */
@Service(version = "v1")
public class UserServiceImpl implements UserService{
    @Override
    public String getName() {
        return "jhy";
    }
}
