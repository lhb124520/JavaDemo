package com.demo.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liu.hb
 *ArrayList��LinkedList�Ĵ�����������:
	1.ArrayList��ʵ���˻��ڶ�̬��������ݽṹ��LinkedList������������ݽṹ�� 
	2.�����������get��set��ArrayList��������LinkedList����ΪLinkedListҪ�ƶ�ָ�롣 
	3.����������ɾ������add��remove��LinedList�Ƚ�ռ���ƣ���ΪArrayListҪ�ƶ����ݡ� 
 */
public class ListTest {
	static final int T = 50000;

	/**
	 * 
	 * @param list ����
	 * @return �б����������Ҫ��ʱ��
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
	 * @param list ����
	 * @return �б��ѯ������Ҫ��ʱ��
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
	 * @param list ����
	 * @return �б��������
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
		
		System.out.println("ArrayList���" + T + "����ʱ��" + timeList(list1));
		System.out.println("LinkedList���" + T + "����ʱ��" + timeList(list2));

//		List<Object> list3 = addList(new ArrayList<>());
//		List<Object> list4 = addList(new LinkedList<>());
		
		System.out.println("ArrayList���ȣ�"+list1.size()+"  LinkedList���ȣ�"+list2.size());
		System.out.println("ArrayList����" + T + "����ʱ��" + readList(list1));
		System.out.println("LinkedList����" + T + "����ʱ��" + readList(list2));
	}

}
