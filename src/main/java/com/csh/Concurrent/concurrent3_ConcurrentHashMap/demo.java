package com.csh.Concurrent.concurrent3_ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc: ConcurrentHashMap 测试
 * @author: CuiShiHao
 **/
public class demo {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap(16);
        map.put("test","test");
        int num = map.size();
        System.out.println(num);
    }

}
