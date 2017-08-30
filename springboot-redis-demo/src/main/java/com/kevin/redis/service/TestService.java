package com.kevin.redis.service;

import com.kevin.redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jkevin on 2017/8/9.
 */
@Service
public class TestService {

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Object> list(User user) {
        ListOperations<Object, Object> ops = redisTemplate.opsForList();
        ops.rightPop("users:list");
        return ops.range("users:list", 0, -1);//取list所有
    }

    public Object map(User user) {
        HashOperations ops = redisTemplate.opsForHash();
        return ops.get("users:hash", user.getIdcard());//取map
    }

    public void insertMap(User user) {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("users:hash", user.getIdcard(), user);
        ops.getOperations().expire("1968959",10, TimeUnit.SECONDS);
    }

    public void insertList(User user) {
        ListOperations ops = redisTemplate.opsForList();
        ops.leftPush("users:list", user);
    }
}
