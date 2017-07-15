package com.kevin.redis.service;

import com.kevin.redis.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jkevin on 2017/7/16.
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {

    private Map<String,User> map = new HashMap<String, User>();

    public void save(User user){
        map.put(user.getIdcard(),user);
    }

    @Cacheable(key = "#user.idcard")
    public User findUser(User user) {
        System.err.println("没有走redis");
        return map.get(user.getIdcard());
    }

//    @CachePut(key = "#user.idcard")
//    public void update(User user){
//        System.err.println("调用了CachePut");
//        map.put(user.getIdcard(),user);
//    }
}
