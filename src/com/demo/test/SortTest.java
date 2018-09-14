package com.demo.test;

public class SortTest {

	private int[] array;
	private int length;

	/**
	 * ���캯��
	 * 
	 * @param array
	 */
	public SortTest(int[] array) {
		this.array = array;
		this.length = array.length;
	}

	/**
	 * ��ӡ����������
	 */
	public void display(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * ð������
	 */
	public void bobSort() {
		for (int i = 0; i < length - 1; i++) {// ��������
			for (int j = 0; j < length - 1; j++) {// �Ƚϴ���
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * ��������
	 */
	public static void quickSort(int array[], int low, int high) {		
		// 1,�ҵ��ݹ��㷨�ĳ���
		if (low > high) {
			return;
		}
		// 2, ��
		int i = low;
		int j = high;
		// 3,key
		int key = array[low];
		// 4�����һ������
		while (i < j) {
			// 4.1 �����������ҵ���һ��С��key����
			while (i < j && array[j] > key) {
				j--;
			}
			// 4.2 ���������ҵ���һ������key����
			while (i < j && array[i] <= key) {
				i++;
			}
			// 4.3 ����
			if (i < j) {
				int p = array[i];
				array[i] = array[j];
				array[j] = p;
			}
		}
		// 4.4������key��λ��
		int p = array[i];
		array[i] = array[low];
		array[low] = p;
		// 5, ��key��ߵ�������
		quickSort(array, low, i - 1);
		// 6, ��key�ұߵ�������
		quickSort(array, i + 1, high);
	}

	public static void main(String[] args) {
		int[] array = { 77, 29, 28, 36, 33, 25, 10 };
		SortTest bobSort = new SortTest(array);
		System.out.println("ð������ǰ������Ϊ��");
		bobSort.display(array);
		
		bobSort.bobSort();		
		
		System.out.println("ð������������Ϊ��");
		bobSort.display(array);
		
		int[] array1 = { 77, 29, 28, 36, 33, 25, 10 };
		SortTest bobSort1 = new SortTest(array1);
		System.out.println("��������ǰ������Ϊ��");
		bobSort1.display(array1);
		quickSort(array1,0,array1.length-1);
		System.out.println("��������������Ϊ��");
		bobSort.display(array1);
	}

}
