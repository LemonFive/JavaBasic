package com.csh.Concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock =new ReentrantLock(true);

        Thread thread1 =new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"执行");
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println(Thread.currentThread()+"释放锁");
            }
        };
        thread1.start();


        Thread thread2 =new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"执行");
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println(Thread.currentThread()+"释放锁");
            }
        };
        thread2.start();

    }
}
