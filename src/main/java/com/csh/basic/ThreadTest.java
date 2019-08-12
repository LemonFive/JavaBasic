package com.csh.basic;

/**
 * @desc: 线程死锁测试
 * @author: CuiShiHao
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (String.class){
                try {
                    Thread.sleep(2000);
                    synchronized (Integer.class){

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (Integer.class){
                try {
                    Thread.sleep(2000);
                    synchronized (String.class){

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
