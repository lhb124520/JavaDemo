package com.demo.Thread;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * cdl.await(long, TimeUnit);等待超时，针对某些业务场景，如果某一个线程的操作耗时非常长或者发生了异常.
 * 但是并不想影响主线程的继续执行, 则可以使用await(long, TimeUnit)方法.
 * 即一个线程(或者多个线程)，等待另外n个线程执行long时间后继续执行.
 * @author liu.hb
 *
 */
public class CountDownLatchTest {
	public static void main(String[] args) {		
		CountDownLatch cdl = new CountDownLatch(3);
		new Test1T21(cdl).start();		
		new Test1T22(cdl).start();
		new Test1T23(cdl).start();		
		try {
			/**
			 * 如果有某个解析sheet的线程处理的比较慢，我们不可能让主线程一直等待，
			 * 所以我们可以使用另外一个带4000ms的await方法，await(long time, TimeUnit unit): 
			 * 这个方法等待特定时间后，就会不再阻塞当前线程。join也有类似的方法。
			 */
			cdl.await(4000, TimeUnit.MILLISECONDS);
			System.out.println("await...");
			// 继续执行下面的逻辑...(略)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Success...");
	}
}
/*
 * 当我们调用一次CountDownLatch的countDown方法时，N就会减1，CountDownLatch的await会阻塞当前线程，
 * 直到N变成零。由于countDown方法可以用在任何地方，所以这里说的N个点，可以是N个线程，也可以是1个线程里的N个执行步骤。
 * 用在多个线程时，你只需要把这个CountDownLatch的引用传递到线程里。
 */
class Test1T21 extends Thread {

	private CountDownLatch cdl;

	Test1T21(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date() + "        name =" + Thread.currentThread().getName());
		cdl.countDown();
	}
}

class Test1T22 extends Thread {

	private CountDownLatch cdl;

	Test1T22(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date() + "      name =" + Thread.currentThread().getName());
		cdl.countDown();
	}
}

class Test1T23 extends Thread {

	private CountDownLatch cdl;

	Test1T23(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date() + "    name =" + Thread.currentThread().getName());
		cdl.countDown();
	}
	
}
