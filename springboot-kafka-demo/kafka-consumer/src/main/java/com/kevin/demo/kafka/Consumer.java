package com.kevin.demo.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author jianghaiyang
 * @create 2017-06-23 下午 5:11
 **/
@Component
public class Consumer {

    @KafkaListener(topics = "topic1")
    public void processMsg(String content) {
        Message msg = JSON.parseObject(content, Message.class);
        System.err.println(msg.toString());
    }
}
