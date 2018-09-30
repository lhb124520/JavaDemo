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
	 * װ�䣺����������ת���ɰ�װ����� ���䣺����װ�����ת���ɻ������͵�ֵ
	 */
	public static void box() {
		// װ��
		Integer i = new Integer(2);// �ֶ�װ��
		int b = i.intValue();// �ֶ�����
		// �Զ�װ��
		Integer i1 = 2;// �Զ�װ��
		int b1 = i;// �Զ�����

		Integer i3 = 100;
		Integer i4 = 100;
		System.out.println(i3 == i4);
		System.out.println("-----------box-----------");
	}

	/**
	 * Ϊʲô��7��Ϊtrue����12��Ϊfalse��?������Ϊ�����Զ�װ��ʱ����ֵ�ӨC128��127֮���ֵ��
	 * ���Ǳ�װ��ΪInteger����󣬻�����ڴ��б����ã�ʼ��ֻ����һ������ ������������˴ӨC128��127֮���ֵ��
	 * ��װ����Integer���󲢲��ᱻ���ã����൱��ÿ��װ��ʱ���½�һ�� Integer����
	 * ��ô��ΪʲôҪ��ô����أ�һ����˵��С���ֵ�ʹ��Ƶ�ʺܸߣ���С���ֱ�������������ʼ�ս���һ��������Խ�Լ�ڴ棬���Ч�ʡ�
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
		System.out.println("---------������������-------------");
		/**
		 * ���������ζ����������ڳ������д����˶���abc����һ�����ڶ��ڴ��д����˶���str1������str1��str2�ĵ�ֵַ����ȡ�
		 */
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
		/**
		 * ���������ڷ�������һ���֣������е�s1��������ʱ�������������û�У����ڳ������д���һ������abc��,
		 * �ڶ��δ�����ʱ�򣬾�ֱ��ʹ�ã��������δ����Ķ�����ʵ��ͬһ���������ǵĵ�ֵַ��ȡ�
		 */
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		System.out.println("---------box1-------------");
		
   
	}
	/**
	 *  Java ���Ͽ��
	 */
    public void collectionTest() {
    	List<UserInfo> s11 = new ArrayList<>();// ��ͬ�����̲߳���ȫ������Ч�ʸ�
		LinkedList<UserInfo> sww = new LinkedList<>();// ��ͬ�����̲߳���ȫ���޸�Ч�ʸ�
		Vector<UserInfo> v = new Vector<>();// ͬ�����̰߳�ȫ
		Map<Object, Object> map = new HashMap<Object, Object>();
		Map<Object, Object> map1 = new Hashtable<Object, Object>();
		map.put(null, null);// ֧�ֿռ���ֵ
		map.put(null, "123");// ֧�ֿռ���ֵ
		System.out.println("------HashMap<String, String>------" + map.get(0));

		try {
			map1.put(null, null);
			System.out.println("------Hashtable<String, String>------" + map1.get(0));
		} catch (Exception e) {
			System.out.println(
					"------HashTable �� put ���ļ�ֵֻҪ��һ�� null��" + "ֱ���׳� NullPointerException------\n" + e.getMessage());
		}
		Set<String> set=new HashSet<>();//HashSet �ײ���ǻ��� HashMap ʵ�ֵ�
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
