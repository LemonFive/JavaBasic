package com.csh.basic;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Thread myThread = new Thread();
        myThread.start();
        myThread.interrupt();
        System.out.println("第一次调用interrupt：" + Thread.interrupted());
        System.out.println("第二次调用interrupt：" + Thread.interrupted());
        System.out.println("END=========================================");
    }
}
