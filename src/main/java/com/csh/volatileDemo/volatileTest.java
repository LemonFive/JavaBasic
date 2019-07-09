package com.csh.volatileDemo;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class volatileTest {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        VolatileExample example = new VolatileExample();
        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    example.getAndIncrement();
                }
            }
        };

        Thread thread2=new Thread() {
            public void run(){
                for(int i=0;i<100000;i++) {
                    example.getAndIncrement();
                }
            }
        };

        thread1.start();
        thread2.start();
        Thread.sleep(20000);//等一会，让线程都执行完。
        System.out.println(example.get());
    }
}

    class VolatileExample{
        volatile int v=0;
        public  void set(int  l) {
            v=l;
        }
        public void getAndIncrement() {
            v++;
        }
        public  int get() {
            return v;
        }
    }

