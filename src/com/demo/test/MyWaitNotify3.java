package com.demo.test;

import com.demo.entity.UserInfo;
/**
 * ��������SMP�ܹ��е�һ��low-level��ͬ�����ơ�
 * ��������ʱ���ͷ�CPU������������������߳�Ӧ�þ����ͷ�������������ȴ������������̻߳�һֱ��������������ͻ��˷�CPUʱ�䡣
        �������������߳���sleep֮ǰӦ���ͷ��������Ա������߳̿��Ի����������
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
