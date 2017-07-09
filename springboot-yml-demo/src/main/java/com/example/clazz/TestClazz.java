package com.example.clazz;

import org.springframework.beans.BeanUtils;

import java.util.HashMap;

/**
 * 方法返回泛型
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class TestClazz {
    static HashMap<String, String> sMap = new HashMap<String, String>();
    public static void main(String[] args) {

        sMap.put("1", "23");

        Object i = getUserInfoByKey("1", new P("www",123l), "234");

        System.out.println("i:"+i.toString());

    }

    protected static <T> T getUserInfoByKey(String key, T clazz, T deffault) {

        String v = sMap.get(key);
        BeanUtils.copyProperties(new P2(111l,222l,"jhy"),clazz);
        if (null != clazz) {
            return clazz;
        }
        return deffault;
    }

}
