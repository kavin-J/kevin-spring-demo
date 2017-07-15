package com.kevin.redis;

import com.kevin.redis.bean.User;
import com.kevin.redis.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jkevin on 2017/7/16.
 */
@SpringBootApplication
@EnableCaching
public class RedisDemoApplication {
    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(RedisDemoApplication.class, args);
        UserService service = context.getBean(UserService.class);

        //save
        service.save(new User(100000L, "320458199004154560", "章小鱼", 22, new SimpleDateFormat("yyyy-mm-dd").parse("1650-11-22")));
    }
}
