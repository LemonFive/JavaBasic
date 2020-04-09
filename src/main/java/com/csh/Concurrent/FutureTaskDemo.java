package com.csh.Concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @desc: FutureTaskDemo
 * @author: CuiShiHao
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> cookTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "5斤的龙虾";
            }
        });

        Long startTime = System.currentTimeMillis();

        System.out.println("我点了5斤的龙虾。");
        new Thread(cookTask).start();

        System.out.println("我去买牙膏。");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("我买到牙膏了！");

        String lunch = cookTask.get();
        System.out.println("我点的" + lunch + "已经OK了！");

        TimeUnit.SECONDS.sleep(2);
        String lunch2 = cookTask.get();
        System.out.println("我点的" + lunch2 + "已经OK了！第二次获取");

        Long userTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("我一共用了" + userTime + "秒买午餐并且买牙膏。");
    }
}
