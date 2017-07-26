package com.kevin.demo.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author Jkevin
 * @create 2017-06-23 下午 5:11
 **/
@Component
public class Consumer {

    @KafkaListener(topics = {"topic1","topic2"})
    public void processMsg(String content) throws InterruptedException {
        Message msg = JSON.parseObject(content, Message.class);
        //System.err.println(msg.toString());
        if("app-1-apple-ios".equals(msg.getAppId())){
            System.err.println(msg.toString());
            System.out.println("这个消息需要推送给app-1-apple-ios");
        }
        Thread.sleep(1000);
        if("app-2-mi-android".equals(msg.getAppId())){
            System.err.println(msg.toString());
            System.out.println("这个消息需要推送给app-2-mi-android");
        }

    }

//    @KafkaListener(topics = {"topic2"})
//    public void processMsg2(String content) {
//        Message msg = JSON.parseObject(content, Message.class);
//        System.err.println(msg.toString());
//    }
}
