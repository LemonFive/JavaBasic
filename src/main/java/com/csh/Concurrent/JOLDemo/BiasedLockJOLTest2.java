package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * 验证  BiasedLockingBulkRevokeThreshold 是针对类的。 类的对象被撤销偏向锁达到设置的阈值后。实例化的对象不再支持偏向锁
 */
public class BiasedLockJOLTest2 {
    static A a;

    public static void main(String[] args) throws Exception {
        Thread.sleep(6000);
//        a = new A();
        List<A> list = new ArrayList<>();
        List<A> list2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new A());
            list2.add(new A());
        }

        Thread t1 = new Thread() {
            String name = "1";

            public void run() {
                out.printf(name);
                for (A a : list) {
                    synchronized (a) {
                        if (a == list.get(10))
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
        out.println("main 预期是偏向锁"+10 + ClassLayout.parseInstance(list.get(10)).toPrintable());//偏向锁

        Thread t2 = new Thread() {
            String name = "2";

            public void run() {
                out.printf(name);

                for(int i = 0;i<100;i++){
                    A a = list.get(i);
                    synchronized (a) {
                        if ( a == list.get(10)) {
                            out.println("t2 i=10 get(1)预期是无锁" +  ClassLayout.parseInstance(list.get(1)).toPrintable());//偏向锁
                            out.println("t2 i=10 get(10) 预期轻量级锁 " + i + ClassLayout.parseInstance(a).toPrintable());//偏向锁
                        }
                        if ( a == list.get(19)) {
                            out.println("t2  i=19  get(10)预期是无锁" + 10 + ClassLayout.parseInstance(list.get(10)).toPrintable());//偏向锁
                            out.println("t2  i=19  get(19) 满足重偏向条件20 预期偏向锁 " + i + ClassLayout.parseInstance(a).toPrintable());//偏向锁
                            out.println("t2  i=19  get(40) 满足重偏向条件20 预期偏向锁 " + i + ClassLayout.parseInstance(list.get(40)).toPrintable());//偏向锁
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
                for (A a : list2) {
                    synchronized (a) {
                        if (a == list2.get(10))
                            out.println("t3 预期是偏向锁"+10 + ClassLayout.parseInstance(a).toPrintable());//偏向锁

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
                   A a = list2.get(i);
                    synchronized (a) {
                        if ( a == list2.get(10)) {
                            out.println("t4 i=10 get(1)预期是无锁" +  ClassLayout.parseInstance(list2.get(1)).toPrintable());//偏向锁
                            out.println("t4 i=10 get(10) 预期轻量级锁 " + i + ClassLayout.parseInstance(a).toPrintable());//偏向锁
                        }
                        if ( a == list2.get(19)) {
                            out.println("t4  i=19  get(10)预期是无锁" + 10 + ClassLayout.parseInstance(list2.get(10)).toPrintable());//偏向锁
                            out.println("t4  i=19  get(19) 满足重偏向条件20 预期偏向锁  " + i + ClassLayout.parseInstance(a).toPrintable());//偏向锁
                            out.println("t4  i=19  get(40) 满足重偏向条件20 预期偏向锁被批量重重偏向 " + i + ClassLayout.parseInstance(list2.get(40)).toPrintable());//偏向锁
                        }

                    }



                }

            }
        };
        t4.start();
        Thread.sleep(5000);
        out.println("由于A撤销锁次数达到默认的 BiasedLockingBulkRevokeThreshold=40 这里实例化的对象 是无锁状态"  + ClassLayout.parseInstance(new A()).toPrintable());//偏向锁
        out.println("由于B撤销锁次数没达到默认的 BiasedLockingBulkRevokeThreshold=40 这里实例化的对象 是偏向锁可以偏向状态"  + ClassLayout.parseInstance(new B()).toPrintable());//偏向锁

    }


}

