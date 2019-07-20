package com.csh.Concurrent.JOLDemo;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class JOLExample12 {
    static List<A> list = new ArrayList<A>();
    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread() {
            public void run() {
                for (int i=0;i<100;i++){
                    A a = new A();
                    synchronized (a){
                        //System.out.println("111111");
                        list.add(a);
                    }
                }

            }

        };
        t1.start();
        t1.join();
        out.println("befre t2");
        //偏向
        out.println(ClassLayout.parseInstance(list.get(1)).toPrintable());



        Thread t2 = new Thread() {
            int k=0;
            public void run() {
                System.out.println("0----19 之间的数 因为t2要用 t1的偏向锁，所以 变成轻量级锁了");
                System.out.println("20----39 之间的数 因为偏向锁撤销 达到 20次后，偏向锁重定向了");
                for (int i = 0; i <40 ; i++) {
                    A a=list.get(i);
                    synchronized (a){
                        //System.out.println("22222");
                        if (k==18||k==19){
                            out.println("t2 ing : "+k);
                            //轻量锁
                            System.out.println("撤销偏量锁达到："+(k+1)+"次");
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }

                    }
                    k++;
                }

                System.out.println("40----49 之间的数 不被遍历 仍然偏向t1");
                for (int i = 40; i <50 ; i++) {
                    k++;
                }

                System.out.println("50----59 之间的数 因为偏向锁撤销 达到 20次后，偏向锁重定向了");
                for (int i = 50; i <60 ; i++) {
                    A a=list.get(i);
                    synchronized (a){
                        //System.out.println("22222");
                        if (k==58||k==59){
                            out.println("t2 ing : "+k);
                            //轻量锁
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }

                    }
                    k++;
                }


            }
        };
        t2.start();
        t2.join();

        out.println("befre t3: 39 ----偏量锁 t2");
        out.println(ClassLayout.parseInstance(list.get(39)).toPrintable());


        out.println("befre t3: 40  ----偏量锁 t1" );
        out.println(ClassLayout.parseInstance(list.get(40)).toPrintable());




        Thread t3 = new Thread() {
            int k=0;
            public void run() {
                for (int i = 30; i <40 ; i++) {
                    A a=list.get(i);
                    synchronized (a) {
                        //System.out.println("22222");
                        if (k == 8 || k == 9) {
                            out.println("t3 ing  " + k);
                            //轻量锁
                            System.out.println("t2的偏向锁,t3要使用，所以变成轻量级锁");
                            System.out.println("撤销偏量锁：" + (20 + k + 1) + "次");
                            out.println(ClassLayout.parseInstance(a).toPrintable());

                        }
                    }
                    k++;
                }
                System.out.println("撤销偏量锁次数 未达到 40 次。");
                System.out.println("40----49 之间的数 之前仍然偏向t1 ，未被重定向过，所以这次被重定向给 t3");
                for (int i = 40; i <50 ; i++) {
                    A a = list.get(i);
                    synchronized (a) {

                        if (k == 18 || k == 19) {
                            System.out.println("t3 ing  " + k + " i:" + i);

                            System.out.println("偏向t3");
                            out.println(ClassLayout.parseInstance(a).toPrintable());

                        }
                    }
                    k++;
                }
                System.out.println("50----59 之间的数  t2的偏向锁,t3要使用，所以变成轻量级锁");

                for (int i = 50; i <60 ; i++) {
                    A a=list.get(i);
                        synchronized (a) {
                            if (k==28||k==29){
                                out.println("t3 ing  "+k);
                                //轻量锁
                                System.out.println("t2的偏向锁,t3要使用，所以变成轻量级锁");
                                System.out.println("撤销偏量锁："+(10+k+1)+"次");
                                out.println(ClassLayout.parseInstance(a).toPrintable());

                            }
                    }
                    k++;
                }
                System.out.println("撤销偏量锁次数 达到 40 次。");
                System.out.println("60----89 之间的数 之前仍然偏向t1 ，未被重定向过，但由于达到了撤销40次 被批量撤销了偏向锁 所以 无法重定向了");
                for (int i = 50; i <90 ; i++) {
                    A a=list.get(i);
                    synchronized (a) {
                        if(k==48||k==49||k==58||k==59){
                            System.out.println("t3 ing  "+k);
                            System.out.println("批量撤销偏量锁后，全部变成 轻量级锁");
                            out.println(ClassLayout.parseInstance(a).toPrintable());

                        }

                    }
                    k++;
                }

            }
        };
        t3.start();
        t3.join();

        out.println("after t3: 90" );
        out.println(ClassLayout.parseInstance(list.get(90)).toPrintable());
    }
}