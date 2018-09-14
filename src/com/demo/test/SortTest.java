package com.demo.test;

public class SortTest {

	private int[] array;
	private int length;

	/**
	 * 构造函数
	 * 
	 * @param array
	 */
	public SortTest(int[] array) {
		this.array = array;
		this.length = array.length;
	}

	/**
	 * 打印数组中数据
	 */
	public void display(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * 冒泡排序
	 */
	public void bobSort() {
		for (int i = 0; i < length - 1; i++) {// 排序轮数
			for (int j = 0; j < length - 1; j++) {// 比较次数
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序
	 */
	public static void quickSort(int array[], int low, int high) {		
		// 1,找到递归算法的出口
		if (low > high) {
			return;
		}
		// 2, 存
		int i = low;
		int j = high;
		// 3,key
		int key = array[low];
		// 4，完成一趟排序
		while (i < j) {
			// 4.1 ，从右往左找到第一个小于key的数
			while (i < j && array[j] > key) {
				j--;
			}
			// 4.2 从左往右找到第一个大于key的数
			while (i < j && array[i] <= key) {
				i++;
			}
			// 4.3 交换
			if (i < j) {
				int p = array[i];
				array[i] = array[j];
				array[j] = p;
			}
		}
		// 4.4，调整key的位置
		int p = array[i];
		array[i] = array[low];
		array[low] = p;
		// 5, 对key左边的数快排
		quickSort(array, low, i - 1);
		// 6, 对key右边的数快排
		quickSort(array, i + 1, high);
	}

	public static void main(String[] args) {
		int[] array = { 77, 29, 28, 36, 33, 25, 10 };
		SortTest bobSort = new SortTest(array);
		System.out.println("冒泡排序前的数据为：");
		bobSort.display(array);
		
		bobSort.bobSort();		
		
		System.out.println("冒泡排序后的数据为：");
		bobSort.display(array);
		
		int[] array1 = { 77, 29, 28, 36, 33, 25, 10 };
		SortTest bobSort1 = new SortTest(array1);
		System.out.println("快速排序前的数据为：");
		bobSort1.display(array1);
		quickSort(array1,0,array1.length-1);
		System.out.println("快速排序后的数据为：");
		bobSort.display(array1);
	}

}
