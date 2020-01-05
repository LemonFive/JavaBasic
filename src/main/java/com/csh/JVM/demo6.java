package com.csh.JVM;


import java.util.ArrayList;
import java.util.List;

/**
 * @desc: MAT使用 测试demo
 * @author: CuiShiHao
 **/
public class demo6 {
    public static void main(String[] args) throws InterruptedException {
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            datas.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }

    static class Data {
    }
}
