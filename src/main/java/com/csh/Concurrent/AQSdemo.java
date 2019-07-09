package com.csh.Concurrent;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class AQSdemo {
    private MyLock lock =new MyLock();
    private int m = 0;
    public int next(){
        lock.lock();
        try {
            return m++;
        }
        finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AQSdemo aqSdemo = new AQSdemo();
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++){
            threads[i] = new Thread(() ->
                    System.out.println(aqSdemo.next()));
            threads[i].start();
        }
    }
}
