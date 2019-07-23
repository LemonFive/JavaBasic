package com.csh.Concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(10);

        //创建10个线程执行任务
        for(int i=0;i<10;i++){
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(10) * 1000);
                    System.out.println(Thread.currentThread().getName() + "执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //计数减一
                    latch.countDown();
                }
            });
            thread.start();
        }

        // 等待检查
        latch.await();

        System.out.println("主线程在等待结束后进行处理");
    }
}