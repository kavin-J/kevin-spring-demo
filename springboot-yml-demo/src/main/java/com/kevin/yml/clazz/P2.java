package com.kevin.yml.clazz;

/**
 * 122
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class P2 {
    Long id;
    Long sid;
    String name;
    String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public P2(Long id, Long sid, String name) {
        this.id = id;
        this.sid = sid;
        this.name = name;
    }

    public P2(Long id, Long sid, String name, String date) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "P2{" +
                "id=" + id +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
