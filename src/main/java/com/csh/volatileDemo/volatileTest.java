package com.csh.volatileDemo;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class volatileTest {

    private static int index = 0;
    private static Object object = "";
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        VolatileExample example = new VolatileExample();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    index++;
                }
            }
        });

        Thread thread2=new Thread() {
            public void run(){
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    index++;
                }
            }
            }
        };

        thread1.start();
        thread2.start();
        Thread.sleep(10000);//等一会，让线程都执行完。
        System.out.println(index);
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

