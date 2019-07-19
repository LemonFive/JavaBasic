package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.out;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class JOLDemo0 {

    static A a;
    public static void main(String[] args) throws Exception {
        a = new A();
        out.println("befre lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());
        sync();


        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        A b = new A();
        out.println("输出B");
        out.println(ClassLayout.parseInstance(b).toPrintable());

        //添加一个偏向锁？
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    out.println("thread2 locking");
                    out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        thread2.start();
        Thread.sleep(10000);
        out.println("after thread2 lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    public  static  void sync() throws InterruptedException {
        synchronized (a){
            out.println("lock ing");
            out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}

