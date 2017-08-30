package com.kevin.yml.demo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * Created by Jkevin on 2017/7/29.
 */
@Component
public class ConsumerService {
    @Reference(version = "v1")
    UserService userService;

    public String getName(){
        return userService.getName();
    }
}
