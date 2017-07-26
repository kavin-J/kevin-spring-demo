package com.kevin.demo.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 生产者
 *
 * @author Jkevin
 * @create 2017-06-23 下午 5:11
 **/
@Component
public class Producer {

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void send(){
        Message msg = new Message();
        msg.setId(new BigDecimal("1"));
        msg.setName("jhy");
        msg.setHome("宝嘉誉峰");
        msg.setSendTime(new Date());
        msg.setAppId("app-1-apple-ios");
        kafkaTemplate.send("topic1", JSON.toJSONString(msg));
        msg.setId(new BigDecimal("2"));
        msg.setAppId("app-2-mi-android");
        kafkaTemplate.send("topic2", JSON.toJSONString(msg));
    }

}
