package chapter5.example5_1;

import java.util.Arrays;

public class TestIntArray {
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 3, 5 };		// 创建并初始化int类型数组
		System.out.print("排序前，使用普通的for循环遍历数组a：");
		for (int i = 0; i < a.length; i++) {	// a.length = 5
			System.out.print(a[i] + ",  ");
		}
		Arrays.sort(a);		// 使用Arrays.sort方法对数组a排序
		System.out.print("\n排序后，使用增强型的for循环遍历数组a：");
		for (int e : a) {	// 每次循环，依次将a中元素的值赋给e
			System.out.print(e + ",  ");
		}
		System.out.print("\n排序后，在数组a中查找值等于4的元素，");
		int index = Arrays.binarySearch(a, 4);
		System.out.println("下标值为：" + index);
	}

	private static int search(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (key == a[i]) {
				return i;
			}
		}
		return -1;
	}
}
