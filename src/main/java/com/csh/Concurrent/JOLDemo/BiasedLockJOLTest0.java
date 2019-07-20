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
public class BiasedLockJOLTest0 {


    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        List<A> listA = new ArrayList<>();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    A a = new A();
                    synchronized (a){
                        listA.add(a);
                    }
                    if(i==99){
                        try {
                            Thread.sleep(100000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        t1.start();


        Thread.sleep(10000);

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    A a =listA.get(i);
                    synchronized (a){
                        if(i==18||i==19){
                            out.println("第"+ i + "次");
                            out.println((ClassLayout.parseInstance(a).toPrintable()));
                        }
                    }
                    if(i==19){
                        break;
                    }
                }
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.start();

        Thread.sleep(10000);
        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 30; i < 100; i++) {
                    A a =listA.get(i);
                    synchronized (a){
                        if(i==50||i==51 ||i==80){
                            out.println("thread3 第"+ i + "次");
                            out.println((ClassLayout.parseInstance(a).toPrintable()));
                        }
                    }
                }
            }
        };
        t3.start();
    }
}

