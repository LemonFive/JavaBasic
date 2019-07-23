package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

public class JOLTest1 {


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        A a = new A();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        thread1.start();

        Thread.sleep(3000);
        thread2.start();
    }
}
