package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mypos on 2017/3/7.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Long,Long> map = new HashMap<Long,Long>();
        map.put(new Long(1), new Long(1));//这里的key是Long类型
        Integer key = new Integer(1);
        boolean result = map.containsKey(key);//这里的key是Integer类型
        System.out.println(result);
    }
}
