package com.csh.Concurrent.concurrent1.demo15;

import java.util.concurrent.locks.ReentrantLock;

public class RLDemo4{

	public static ReentrantLock lock =new ReentrantLock();
	public static class EvenClass implements Runnable {
		@Override
		public void run() {
			int i = 2;
			while (i <= 100) {
				lock.lock();
				try {
					System.out.println("偶数：" + i);
				}
				catch(Exception e){

				}
				finally{
					i = i + 2;
					lock.unlock();
				}
			}
		}
	}

	public static class OddClass implements Runnable {
		@Override
		public void run() {
			int i = 1;
			while (i <= 100) {
				lock.lock();
				try {
					System.out.println("奇数：" + i);
				}
				catch(Exception e){

				}
				finally{
					i = i + 2;
					lock.unlock();
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new EvenClass());
		Thread t2 = new Thread(new OddClass());
		t1.start();
		t2.start();
	}

}
