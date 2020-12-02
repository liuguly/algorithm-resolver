package com.lddw.algorithm.resolver.zs.basics.one;

import cn.hutool.core.util.ArrayUtil;

/**
 * <p>描述 TODO</p>
 *
 * @author LiuXin
 * @date 2020/11/25 17:06
 * @since 1.0
 **/
public class InsertSort {

	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0 ~ 0 有序的
		// 0 ~ 1 排序
		// 0 ~ 2 排序
		// 0 ~ 3 排序
		// 0 ~ i 想有序
		// 核心要限定i的最右边位置，外层循环就干这个事
		for (int i = 1; i < arr.length; i++) {
			//内部循环始终是i前面一个数和当前i比较，同时递减索引
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		arr[j] = arr[j] ^ arr[i];
		arr[i] = arr[j] ^ arr[i];
		arr[j] = arr[i] ^ arr[j];
	}

	public static void main(String[] args) {
		int[] arr = {2, 4, 3, 11, 7, 6, 9, 7, 22, 15, 13, 11};
		insertionSort(arr);
		System.out.println(ArrayUtil.toString(arr));
		int a = 1;
		int b = 1;
		System.out.println(a ^ b);
	}

}
