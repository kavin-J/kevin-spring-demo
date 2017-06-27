package com.kevin.demo.kafka;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 消息对象
 *
 * @author jianghaiyang
 * @create 2017-06-23 下午 5:05
 **/
public class Message {

    private BigDecimal id;
    private String name;
    private String home;

    private Date sendTime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", home='" + home + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
