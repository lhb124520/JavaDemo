package com.demo.Thread;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * cdl.await(long, TimeUnit);�ȴ���ʱ�����ĳЩҵ�񳡾������ĳһ���̵߳Ĳ�����ʱ�ǳ������߷������쳣.
 * ���ǲ�����Ӱ�����̵߳ļ���ִ��, �����ʹ��await(long, TimeUnit)����.
 * ��һ���߳�(���߶���߳�)���ȴ�����n���߳�ִ��longʱ������ִ��.
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
			 * �����ĳ������sheet���̴߳���ıȽ��������ǲ����������߳�һֱ�ȴ���
			 * �������ǿ���ʹ������һ����4000ms��await������await(long time, TimeUnit unit): 
			 * ��������ȴ��ض�ʱ��󣬾ͻ᲻��������ǰ�̡߳�joinҲ�����Ƶķ�����
			 */
			cdl.await(4000, TimeUnit.MILLISECONDS);
			System.out.println("await...");
			// ����ִ��������߼�...(��)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Success...");
	}
}
/*
 * �����ǵ���һ��CountDownLatch��countDown����ʱ��N�ͻ��1��CountDownLatch��await��������ǰ�̣߳�
 * ֱ��N����㡣����countDown�������������κεط�����������˵��N���㣬������N���̣߳�Ҳ������1���߳����N��ִ�в��衣
 * ���ڶ���߳�ʱ����ֻ��Ҫ�����CountDownLatch�����ô��ݵ��߳��
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
