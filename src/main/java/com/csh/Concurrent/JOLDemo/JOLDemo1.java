package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.out;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class JOLDemo1 {
    public static void main(String[] args) throws InterruptedException {

        // JVM 启动时会默认延时加载偏向锁
        // 设置 -XX:BiasedLockingStartupDelay=0 取消延时加载偏向锁。
        //注：未设置-XX:BiasedLockingStartupDelay=0 或 启动时Thread.sleep 时 befor lock 为无锁
        //注：  设置-XX:BiasedLockingStartupDelay=0 或 启动时Thread.sleep 时 befor lock 为偏向锁 可偏向状态
         Thread.sleep(5000);
        A a = new A();
        out.println("before lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());    //并不是无锁状态， 而是可偏向状态。

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    out.println("thread1 locking");
                    out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    out.println("thread2 locking");
                    out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };

        thread1.start();
        thread2.start();

        Thread.sleep(10000);
        out.println("After compete");
        out.println(ClassLayout.parseInstance(a).toPrintable());


        out.println("在此添加偏向锁");

        Thread thread3 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    out.println("thread3 locking");
                    out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        thread3.start();


        Thread.sleep(10000);
        out.println("Finish");
        out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
