package com.demo.Thread;

/**
 * Java线程的优先级从1到10级别，值越大优先级越高
 * 
 * @author liu.hb
 *
 */
public class ThreadPriority {

	public static void main(String[] args) {

		MyThead myThead = new MyThead();
		Thread thread = new Thread(myThead);
		MyThread2 thread2 = new MyThread2();

		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();

		thread2.setPriority(Thread.MAX_PRIORITY);
		thread2.start();
	}

}

class MyThead implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.activeCount() + "thread======>AAA");
		}

	}

}

class MyThread2 extends Thread {

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.activeCount() + "thread======BBB");
		}
	}

}
