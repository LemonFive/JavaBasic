package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;
import static java.lang.System.out;
/**
 * @desc:
 * @author: CuiShiHao
 **/
public class JOLDemo4 {
    public static A a;
    public static void main(String[] args) throws Exception {
        //Thread.sleep(5000);
        a = new A();
        out.println("befre lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());//无锁

        Thread t1= new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("t1 lock");
                    out.println(ClassLayout.parseInstance(a).toPrintable());//无锁
                }
            }
        };
        t1.start();
        Thread.sleep(10000);

        Thread t2= new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("t2 lock");
                    out.println(ClassLayout.parseInstance(a).toPrintable());//无锁
                }
            }
        };
        t2.start();
        t2.join();
//        Thread.sleep(10000);
        synchronized (a){
            out.println("main lock ing");
            out.println(ClassLayout.parseInstance(a).toPrintable());//轻量锁
        }
    }
}
