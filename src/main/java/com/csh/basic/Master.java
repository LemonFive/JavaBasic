package com.csh.basic;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class Master {
    static int a = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(a);
        });

        t1.start();
        a=5;
    }
}
