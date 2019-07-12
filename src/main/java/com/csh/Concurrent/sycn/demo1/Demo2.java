package com.csh.Concurrent.sycn.demo1;

public class Demo2 {

    public int count = 10;

    public void test() throws InterruptedException {
        //synchronized(this)锁定的是当前类的实例,这里锁定的是Demo2类的实例
        synchronized (this){
            count--;
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}