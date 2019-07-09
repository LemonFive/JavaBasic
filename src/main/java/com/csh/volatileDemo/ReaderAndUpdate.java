package com.csh.volatileDemo;

import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class ReaderAndUpdate {
    private static int MAX = 10;
    private static volatile int init_value = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                int localValue = init_value;
                while(localValue < MAX){
                    if(localValue != init_value) {
                        System.out.println("Reader:" + init_value);
                        localValue = init_value;
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                int localValue = init_value;
                while(localValue < MAX){
                    System.out.println("Update:" + (++localValue) );
                    init_value =localValue;
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
