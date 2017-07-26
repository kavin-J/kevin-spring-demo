package com.kevin.demo.kafka;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消息对象
 *
 * @author Jkevin
 * @create 2017-06-23 下午 5:05
 **/
public class Message {

    private BigDecimal id;

    private String appId;

    private String name;

    private String home;

    private Date sendTime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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
                ", appId='" + appId + '\'' +
                ", name='" + name + '\'' +
                ", home='" + home + '\'' +
                ", sendTime=" + new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(sendTime) +
                '}';
    }
}
