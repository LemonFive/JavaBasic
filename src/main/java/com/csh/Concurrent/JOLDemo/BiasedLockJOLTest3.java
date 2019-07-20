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
public class BiasedLockJOLTest3 {


    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        List<A> listA = new ArrayList<>();

        //创建100个偏向t1的对象锁
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

        //确保t1线程初始化大部分数据了。
        Thread.sleep(10000);

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 90; i++) {
                    A a =listA.get(i);
                    synchronized (a){
                        if(i==18||i==19){
                            out.println("第"+ (i + 1) + "次");
                            out.println((ClassLayout.parseInstance(a).toPrintable()));
                        }
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

        //确保t2线程重偏向了大部分数据。
        Thread.sleep(10000);

        //实例化对象测试
        out.println("实例化对象测试");
        out.println((ClassLayout.parseInstance(new A()).toPrintable()));

        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 30; i < 55; i++) {
                    A a =listA.get(i);
                    synchronized (a){
                        if(i==30|| i==48 || i==49 ||i==50 ){
                            out.println("thread3 第"+ (i-29) + "次");
                            out.println((ClassLayout.parseInstance(a).toPrintable()));
                            //实例化对象测试
                            out.println("实例化对象测试");
                            out.println((ClassLayout.parseInstance(new A()).toPrintable()));
                        }
                    }
                }
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t3.start();


        //确保t3线程再次重偏向了大部分数据。
        Thread.sleep(10000);


    }
}

