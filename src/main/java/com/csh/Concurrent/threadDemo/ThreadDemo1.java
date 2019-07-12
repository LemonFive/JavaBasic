package com.csh.Concurrent.threadDemo;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(){
            @Override
            public void run() {
                System.out.println("线程被执行！");
            }
        };


        thread.start();
        Thread.sleep(1000);
        System.out.println("============");
        thread.start();
//        thread.interrupt();
//        thread.notify();
//        thread.notifyAll();
//        Thread.sleep(1000);
//        Thread.yield();

    }
}
