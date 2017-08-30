package com.kevin.yml.clazz;

import org.springframework.beans.BeanUtils;

/**
 * 方法返回泛型
 * 字段类型不匹配则不copy该字段
 *
 * @author Jkevin
 * @create 2017-07-06
 **/
public class TestClazz {
    public static void main(String[] args) {

        Object i = getUserInfoByKey("1", new P("www", 123L), "234");

        System.out.println("i:" + i.toString());

    }

    protected static <T> T getUserInfoByKey(String key, T clazz, T deffault) {

        BeanUtils.copyProperties(new P2(111L, 222L, "jhy", "2015-10-11 15:12:45"), clazz);
        if (null != clazz) {
            return clazz;
        }
        return deffault;
    }

}
