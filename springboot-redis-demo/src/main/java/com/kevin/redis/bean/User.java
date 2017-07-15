package com.kevin.redis.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mypos on 2017/7/16.
 */
public class User implements Serializable{
    Long id;
    String idcard;
    String name;
    Integer age;
    Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(Long id, String idcard, String name, Integer age, Date birthday) {
        this.id = id;
        this.idcard = idcard;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
