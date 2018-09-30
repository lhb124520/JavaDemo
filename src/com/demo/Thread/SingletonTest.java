package com.demo.Thread;

public class SingletonTest {

	public static void main(String[] args) {

	}

	/**
	 * ����ʽ���̲߳���ȫ ����ʽ��Ҫ˫������������ܵ��̰߳�ȫ���⡣
	 * 
	 * @author liu.hb
	 *
	 */
	public static class SingletonDemo {
		private static SingletonDemo instance;

		public SingletonDemo() {
			super();
		}

		public static SingletonDemo getInstance() {
			instance = new SingletonDemo();
			return instance;

		}

	}

	/**
	 * ����ʽ���̰߳�ȫ ˫������������ܵ��̰߳�ȫ���⡣
	 * ��Ϊ�п���thread1��if��instance==null���ж�Ϊ��ʱ������if���ﵫ��û��ʼʵ������
	 * ����ʱthread2Ҳ�����ˣ����վͻ���2��ʵ���ˡ�
	 * 
	 * @author liu.hb
	 *
	 */
	public static class SingletonDemoSave {
		private static SingletonDemoSave instance;

		public SingletonDemoSave() {
			super();
		}

		public static synchronized SingletonDemoSave getInstance() {
			synchronized (SingletonDemoSave.class) {
				instance = new SingletonDemoSave();
			}
			return instance;

		}

	}

	/**
	 * ����ʽ���̰߳�ȫ ��һ���ؾ�ʵ��������ǰռ��ϵͳ��Դ
	 * 
	 * @author liu.hb
	 *
	 */
	public static class SingletonDemo1 {
		private static SingletonDemo1 instance = new SingletonDemo1();

		public SingletonDemo1() {
			super();
		}

		public static SingletonDemo1 getInstance() {
			return instance;
		}

	}

	/**
	 * ����ʽ���̰߳�ȫ ��һ���ؾ�ʵ��������ǰռ��ϵͳ��Դ ���õõ�ʵ��������ʱ���ڲ���Ż���أ��������ӻ��˼���ʱ��������˳������е�Ч��
	 * 
	 * @author liu.hb
	 *
	 */
	public static class SingletonDemoQuick {
		public static class SingletonHold {
			private static SingletonDemoQuick instance = new SingletonDemoQuick();
		}

		public SingletonDemoQuick() {
			super();
		}

		public static SingletonDemoQuick getInstance() {
			return SingletonHold.instance;
		}

	}
}
