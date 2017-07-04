package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by mypos on 2017/7/1.
 */

@ConfigurationProperties(prefix = "terminal")
public class TestProp {
    private String name;
    private Integer age;
    private boolean isSuccess;
    private List<String> list;
    private Map<String,String> latestVersionMap;
    private Map<String,String> cmdMap;

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

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getLatestVersionMap() {
        return latestVersionMap;
    }

    public void setLatestVersionMap(Map<String, String> latestVersionMap) {
        this.latestVersionMap = latestVersionMap;
    }

    public Map<String, String> getCmdMap() {
        return cmdMap;
    }

    public void setCmdMap(Map<String, String> cmdMap) {
        this.cmdMap = cmdMap;
    }
}
