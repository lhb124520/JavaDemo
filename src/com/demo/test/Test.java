package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import com.demo.entity.UserInfo;

public class Test {
	/**
	 * 装箱：将基本类型转换成包装类对象 拆箱：将包装类对象转换成基本类型的值
	 */
	public static void box() {
		// 装箱
		Integer i = new Integer(2);// 手动装箱
		int b = i.intValue();// 手动拆箱
		// 自动装箱
		Integer i1 = 2;// 自动装箱
		int b1 = i;// 自动拆箱

		Integer i3 = 100;
		Integer i4 = 100;
		System.out.println(i3 == i4);
		System.out.println("-----------box-----------");
	}

	/**
	 * 为什么第7行为true而第12行为false呢?这是因为，在自动装箱时对于值从–128到127之间的值，
	 * 它们被装箱为Integer对象后，会存在内存中被重用，始终只存在一个对象 。而如果超过了从–128到127之间的值，
	 * 被装箱后的Integer对象并不会被重用，即相当于每次装箱时都新建一个 Integer对象。
	 * 那么，为什么要这么设计呢？一般来说，小数字的使用频率很高，将小数字保存起来，让其始终仅有一个对象可以节约内存，提高效率。
	 */
	public static void box1() {
		Integer a = 1;
		Integer b = 1;
		Integer c = 144;
		Integer d = 144;
		Integer a1 = new Integer(1);
		Integer b1 = new Integer(1);
		System.out.println(a == b); // true
		System.out.println(a.equals(b)); // true
		System.out.println(a1 == b1); // false
		System.out.println(a1.equals(b1)); // true
		System.out.println(c == d); // false
		System.out.println(c.equals(d)); // true
		System.out.println("---------基本数据类型-------------");
		/**
		 * 创建了两次对象，依次是在常量池中创建了对象”abc”，一次是在堆内存中创建了对象str1，所以str1和str2的地址值不相等。
		 */
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
		/**
		 * 常量池属于方法区的一部分，当运行到s1创建对象时，如果常量池中没有，就在常量池中创建一个对象”abc”,
		 * 第二次创建的时候，就直接使用，所以两次创建的对象其实是同一个对象，它们的地址值相等。
		 */
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		System.out.println("---------box1-------------");
		
   
	}
	/**
	 *  Java 集合框架
	 */
    public void collectionTest() {
    	List<UserInfo> s11 = new ArrayList<>();// 不同步，线程不安全，访问效率高
		LinkedList<UserInfo> sww = new LinkedList<>();// 不同步，线程不安全，修改效率高
		Vector<UserInfo> v = new Vector<>();// 同步，线程安全
		Map<Object, Object> map = new HashMap<Object, Object>();
		Map<Object, Object> map1 = new Hashtable<Object, Object>();
		map.put(null, null);// 支持空键空值
		map.put(null, "123");// 支持空键空值
		System.out.println("------HashMap<String, String>------" + map.get(0));

		try {
			map1.put(null, null);
			System.out.println("------Hashtable<String, String>------" + map1.get(0));
		} catch (Exception e) {
			System.out.println(
					"------HashTable 中 put 进的键值只要有一个 null，" + "直接抛出 NullPointerException------\n" + e.getMessage());
		}
		Set<String> set=new HashSet<>();//HashSet 底层就是基于 HashMap 实现的
	}
	public synchronized static void main(String[] args) {
		// int x,a=5,b=6,c=7;
		// x=++a+b+++c++;
		// System.out.println(x+"");
		//
		// int []i=new int[5];
		// System.out.println(i[4]);
		box();
		box1();
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a + b));
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));
		System.out.println(g.equals(a + b));
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("1");
		hashSet.add("2");
		hashSet.add("1");
		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}

	}

}
