package com.csh.basic;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("执行线程Thread1");
            }
        };

        thread1.run();
    }
}
