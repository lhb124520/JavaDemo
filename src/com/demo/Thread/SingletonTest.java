package com.demo.Thread;

public class SingletonTest {

	public static void main(String[] args) {

	}

	/**
	 * 懒汉式，线程不安全 懒汉式需要双重锁定解决可能的线程安全问题。
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
	 * 懒汉式，线程安全 双重锁定解决可能的线程安全问题。
	 * 因为有可能thread1在if（instance==null）判断为真时进入了if体里但又没开始实例化，
	 * 而这时thread2也进来了，最终就会有2个实例了。
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
	 * 饿汉式，线程安全 类一加载就实例化，提前占用系统资源
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
	 * 饿汉式，线程安全 类一加载就实例化，提前占用系统资源 调用得到实例方法的时候内部类才会加载，这样就延缓了加载时机，提高了程序运行的效率
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
