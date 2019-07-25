package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


/**
 * 重偏向不会修改线程ID的值，只是不同线程的线程ID相同，形成了重偏向的效果
 * -XX:+PrintFlagsFinal  输出JVM 默认参数值信息
 *  intx BiasedLockingBulkRebiasThreshold          = 20   偏向锁批量重偏向阈值
 *  intx BiasedLockingBulkRevokeThreshold          = 40   偏向锁批量撤销阈值
 */
public class BiasedLockJOLTest {


    public static void main(String[] args) throws Exception {
        //延时产生可偏向对象
        Thread.sleep(5000);
        List<A> listA = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i <100 ; i++) {
                A a = new A();
                synchronized (a){
                    listA.add(a);
                }
            }
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(3000);



        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                A a =listA.get(i);
                synchronized (a){
                    if(i==18||i==19){
                        out.println("第"+ ( i + 1) + "次偏向结果");
                        out.println((ClassLayout.parseInstance(a).toPrintable()));
                    }
                }
            }
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        Thread.sleep(3000);
        out.println("打印list中第11个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(10)).toPrintable()));
        out.println("打印list中第26个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(25)).toPrintable()));
        out.println("打印list中第90个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(89)).toPrintable()));

        //Thread.sleep(10000);
        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 20; i < 59; i++) {
                    A a =listA.get(i);
                    synchronized (a){
                        if(i==20||i==22 ||i==30 ||i==85){
                            out.println("thread3 第"+ i + "次");
                            out.println((ClassLayout.parseInstance(a).toPrintable()));
                            out.println((ClassLayout.parseInstance(listA.get(80)).toPrintable()));
                        }
                    }
                }
            }
        };
        t3.start();

        Thread.sleep(10000);
        out.println("重新输出对象A");
        out.println((ClassLayout.parseInstance(new A()).toPrintable()));
    }
}

