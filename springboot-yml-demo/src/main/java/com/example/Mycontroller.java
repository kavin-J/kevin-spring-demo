package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by mypos on 2017/7/1.
 */
@RestController
public class Mycontroller {
    @Resource
    TestProp testProp;

    @GetMapping("test")
    public String getMap() {
        Map map = testProp.getLatestVersionMap();
        Map cmdMap = testProp.getCmdMap();
        Object rr = map.get("12345");
        Assert.isTrue("".equals(null));
        return "1234";
    }
}
