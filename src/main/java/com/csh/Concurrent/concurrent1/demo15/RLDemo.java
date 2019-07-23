package com.csh.Concurrent.concurrent1.demo15;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc:  通过ReentrantLock实现交替打印奇数和偶数
 * @author: CuiShiHao
 **/
public class RLDemo {

    static AtomicInteger num = new AtomicInteger(0);
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<50;i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "获得锁：输出" + num.incrementAndGet());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            for(int i=0;i<50;i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "获得锁：输出" + num.incrementAndGet());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

