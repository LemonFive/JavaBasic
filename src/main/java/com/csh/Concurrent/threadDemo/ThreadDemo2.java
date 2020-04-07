package com.csh.Concurrent.threadDemo;

/**
 * @desc: 使用三个线程循环打印abc十次
 * @author: CuiShiHao
 **/
public class ThreadDemo2 {

    public static int count = 30;

    public static class TestThread extends Thread {
        Thread monitorThread;

        public void setMonitorThread(Thread monitorThread) {
            this.monitorThread = monitorThread;
        }

        private String context;

        public void setContext(String context) {
            this.context = context;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (monitorThread) {
                    synchronized (this) {
                        if (count-- > 0) {
                            System.out.print(context);
                            this.notify();
                        } else {
                            break;
                        }
                    }

                    try {
                        monitorThread.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        TestThread threadA = new TestThread();
        TestThread threadB = new TestThread();
        TestThread threadC = new TestThread();

        threadA.setMonitorThread(threadC);
        threadB.setMonitorThread(threadA);
        threadC.setMonitorThread(threadB);
        threadA.setContext("A");
        threadB.setContext("B");
        threadC.setContext("C");

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();
    }

}
