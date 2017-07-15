package com.example.clazz;

import org.springframework.beans.BeanUtils;

import java.util.HashMap;

/**
 * 方法返回泛型
 * 字段类型不匹配则不copy该字段
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class TestClazz {
    public static void main(String[] args) {

        Object i = getUserInfoByKey("1", new P("www",123l), "234");

        System.out.println("i:"+i.toString());

    }

    protected static <T> T getUserInfoByKey(String key, T clazz, T deffault) {

        BeanUtils.copyProperties(new P2(111l,222l,"jhy","2015-10-11 15:12:45"),clazz);
        if (null != clazz) {
            return clazz;
        }
        return deffault;
    }

}
