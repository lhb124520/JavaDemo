package com.demo.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liu.hb
 *ArrayList和LinkedList的大致区别如下:
	1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。 
	2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。 
	3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。 
 */
public class ListTest {
	static final int T = 50000;

	/**
	 * 
	 * @param list 参数
	 * @return 列表添加数据需要的时间
	 */
	static long timeList(List<Object> list) {
		long start = System.currentTimeMillis();
		Object object = new Object();
		for (int i = 0; i < T; i++) {
			list.add(0, object);
		}
		long time = System.currentTimeMillis() - start;
		return time;
	}
	/**
	 * 
	 * @param list 参数
	 * @return 列表查询数据需要的时间
	 */
	static long readList(List<Object> list) {
		long start = System.currentTimeMillis();
		for (int i = 0, j = list.size(); i < j; i++) {

		}
		long time = System.currentTimeMillis() - start;
		return time;
	}

	/**
	 * 
	 * @param list 参数
	 * @return 列表添加数据
	 */
	static List<Object> addList(List<Object> list) {
		Object object = new Object();
		for (int i = 0; i < T; i++) {
			list.add(0, object);
		}
		return list;
	}

	public static void main(String[] args) {
		List<Object> list1 = new ArrayList<Object>();
		List<Object> list2 = new LinkedList<Object>();
		
		System.out.println("ArrayList添加" + T + "条耗时：" + timeList(list1));
		System.out.println("LinkedList添加" + T + "条耗时：" + timeList(list2));

//		List<Object> list3 = addList(new ArrayList<>());
//		List<Object> list4 = addList(new LinkedList<>());
		
		System.out.println("ArrayList长度："+list1.size()+"  LinkedList长度："+list2.size());
		System.out.println("ArrayList查找" + T + "条耗时：" + readList(list1));
		System.out.println("LinkedList查找" + T + "条耗时：" + readList(list2));
	}

}
