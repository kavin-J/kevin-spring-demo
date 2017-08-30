package com.kevin.yml.clazz;

import java.util.Date;

/**
 * 111
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class P {
    String name;
    Long id;
    String date;

    public P(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public P(String name, Long id, String date) {
        this.name = name;
        this.id = id;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "P{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }

    public static void main(String[] args) {
        Long aaa = 11111L;
        Short bbb = 1;
        System.out.println(aaa.intValue());
        System.out.println(bbb);
    }
}
