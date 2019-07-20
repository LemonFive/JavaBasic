package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CountDownLatch;
import static java.lang.System.out;
public class JOLExample9 {
    static A a;
    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        a = new A();
        out.println("befre lock");
        out.println("无锁"+ClassLayout.parseInstance(a).toPrintable());//无锁
        Thread t1= new Thread(){
            public void run() {
                synchronized (a){
                    System.out.println("var t1 ID =" + Thread.currentThread().getId());
                    System.out.println("t1 release");
                    out.println("t1 "+ClassLayout.parseInstance(a).toPrintable());//偏向锁
                }
            }
        };
        t1.start();
        Thread.sleep(5000);
        Thread t2= new Thread(){
            public void run() {
                synchronized (a){
                    System.out.println("var t2 ID =" + Thread.currentThread().getId());
                    System.out.println("t2 release");
                    out.println("t2 "+ClassLayout.parseInstance(a).toPrintable());//轻量锁
                }

            }
        };
        t2.start();
        Thread.sleep(5000);
        Thread t3= new Thread(){
            public void run() {
                synchronized (a){
                    System.out.println("var t3 ID =" + Thread.currentThread().getId());
                    System.out.println("t3 release");
                    out.println("t3 "+ClassLayout.parseInstance(a).toPrintable());//轻量锁
                }

            }
        };
        t3.start();
        Thread.sleep(5000);
        System.gc();
        out.println("after gc()");
        out.println(ClassLayout.parseInstance(a).toPrintable());//无锁---gc
    }

}
