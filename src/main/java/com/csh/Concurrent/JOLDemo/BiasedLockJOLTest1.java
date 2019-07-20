package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;



/**
 * 验证  BiasedLockingBulkRebiasThreshold 是针对对象集合的
 */
public class BiasedLockJOLTest1 {


    public static void main(String[] args) throws Exception {
        Thread.sleep(6000);
//        a = new A();
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listA.add(new A());
            listB.add(new B());
        }

        Thread t1 = new Thread() {
            @Override
            public void run() {
                out.printf(Thread.currentThread().getName());
                for (A a : listA) {
                    synchronized (a) {
                        if (a == listA.get(10))
                            out.println("t1 预期是偏向锁"+10 + ClassLayout.parseInstance(a).toPrintable());//偏向锁
                    }
                }
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        Thread.sleep(5000);
        out.println("main 预期是偏向锁"+10 + ClassLayout.parseInstance(listA.get(10)).toPrintable());//偏向锁

        Thread t2 = new Thread() {
            @Override
            public void run() {
                out.printf(Thread.currentThread().getName());

                for(int i = 0;i<100;i++){
                    A a = listA.get(i);
                    synchronized (a) {
                        if ( a == listA.get(10)) {
                            out.println("t2 i=10 get(1)预期是无锁" +  ClassLayout.parseInstance(listA.get(1)).toPrintable());//无锁
                            out.println("t2 i=10 get(10) 预期轻量级锁 " + i + ClassLayout.parseInstance(a).toPrintable());   //轻量锁
                        }
                        if ( a == listA.get(19)) {
                            out.println("t2  i=19  get(10)预期是无锁" + 10 + ClassLayout.parseInstance(listA.get(10)).toPrintable());//无锁
                            out.println("t2  i=19  get(19) 满足重偏向条件20 预期偏向锁 " + i + ClassLayout.parseInstance(a).toPrintable());//偏向锁
                            out.println("t2  i=19  get(40) 满足重偏向条件20 预期偏向锁被批量重重偏向 " + i + ClassLayout.parseInstance(listA.get(40)).toPrintable());//偏向锁
                        }
                    }
                }



                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        t2.start();

        Thread.sleep(5000);


        Thread t3 = new Thread() {
            String name = "3";

            public void run() {

                out.printf(name);
                for (B b : listB) {
                    synchronized (b) {
                        if (b == listB.get(10))
                            out.println("t3 预期是偏向锁"+10 + ClassLayout.parseInstance(b).toPrintable());//偏向锁

                    }

                }

                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t3.start();
        Thread.sleep(5000);

        Thread t4 = new Thread() {
            String name = "4";

            public void run() {

                out.printf(name);

                for(int i = 0;i<100;i++){
                    B b = listB.get(i);
                    synchronized (b) {
                        if ( b == listB.get(10)) {
                            out.println("t4 i=10 get(1)预期是无锁" +  ClassLayout.parseInstance(listB.get(1)).toPrintable());//偏向锁
                            out.println("t4 i=10 get(10) 预期轻量级锁 " + i + ClassLayout.parseInstance(b).toPrintable());//偏向锁
                        }
                        if ( b == listB.get(19)) {
                            out.println("t4  i=19  get(10)预期是无锁" + 10 + ClassLayout.parseInstance(listB.get(10)).toPrintable());//偏向锁
                            out.println("t4  i=19  get(19) 满足重偏向条件20 预期偏向锁  " + i + ClassLayout.parseInstance(b).toPrintable());//偏向锁
                            out.println("t4  i=19  get(40) 满足重偏向条件20 预期偏向锁被批量重重偏向 " + i + ClassLayout.parseInstance(listB.get(40)).toPrintable());//偏向锁
                        }
                    }
                }
            }
        };
        t4.start();
        Thread.sleep(5000);
        out.println("由于A撤销锁次数没达到默认的 BiasedLockingBulkRevokeThreshold=40 这里实例化的对象 是偏向锁可以偏向状态"  + ClassLayout.parseInstance(new A()).toPrintable());//偏向锁
    }
}

