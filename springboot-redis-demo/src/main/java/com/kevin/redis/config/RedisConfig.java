package com.kevin.redis.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by Jkevin on 2017/8/9.
 */
@Configuration
public class RedisConfig {

    @Bean(name = "connectionFactory")
    public RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }

//    @Primary
//    @Bean(name = "ttpRedisTemplate")
//    @Qualifier(value = "ttpRedisConnectionFactory")
//    public StringRedisTemplate ttpRedisTemplate(JedisConnectionFactory connectionFactory) {
//
//        StringRedisTemplate redisTemplate = new StringRedisTemplate(connectionFactory);
//
//        // 设置序列化类
//        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//
//        redisTemplate.afterPropertiesSet();
//
//        return redisTemplate;
//
//    }

    @Primary
    @Bean(name = "redisTemplate")
    @Qualifier(value = "connectionFactory")
    public RedisTemplate getRedisTemplate(RedisConnectionFactory connectionFactory) {
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        RedisTemplate redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        System.err.println("-----------------------------------------");
        return redisTemplate;
    }
}
