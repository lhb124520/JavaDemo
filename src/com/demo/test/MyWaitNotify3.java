package com.demo.test;

import com.demo.entity.UserInfo;
/**
 * 自旋锁是SMP架构中的一种low-level的同步机制。
 * 由于自旋时不释放CPU，因而持有自旋锁的线程应该尽快释放自旋锁，否则等待该自旋锁的线程会一直在那里自旋，这就会浪费CPU时间。
        持有自旋锁的线程在sleep之前应该释放自旋锁以便其它线程可以获得自旋锁。
 * @author liu.hb
 *
 */
public class MyWaitNotify3 {
	static  UserInfo myMonitorObject = new UserInfo();
	static boolean wasSignalled = false;

	public static void doWait() {		
		synchronized (myMonitorObject) {
			while (!wasSignalled) {
				try {
					myMonitorObject.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
			wasSignalled = false;
		}
	}

	public static void doNotify() {
		synchronized (myMonitorObject) {
			wasSignalled = true;
			myMonitorObject.notify();
		}
	}

	public static void main(String[] args) {
		doNotify();
	}

}
