package com.csh.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 堆内存溢出的场景
 *
 * 配置参数 -Xms10m -Xmx10m，
 * 我们限制了堆内存大小总共就只有10m
 * @author: CuiShiHao
 **/
public class demo9 {

    public static void main(String[] args) {
        long counter = 0;
        List<Data> list = new ArrayList<>();
        while(true){
            System.out.println("第"+(++counter)+"次创建Object");
            list.add(new Data());
        }
    }

    static class Data {
    }
}
