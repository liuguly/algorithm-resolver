package com.lddw.algorithm.resolver.zs.basics.two;

/**
 * <p>描述 TODO</p>
 * @date 2020/11/27 15:38
 * @author LiuXin
 * @since 1.0
 **/
public class GetMax {

	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}

	public static int process(int[] arr, int L, int R) {
		//范围内只有一个数，直接返回，最大就是自己
		if (L == R)
			return arr[L];
		//直接写mid =(L+R)/2 可能会溢出
		//中点 mid = L + (R-L)/2;  -> L + (R-L)>>1  右移一位就是除以2
		int mid = L + ((R - L) >> 1);
		int leftMax = process(arr, L, mid);
		int rightMax = process(arr, mid + 1, R);
		return Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
		int[] arr = {3, 2, 6, 9, 5, 7, 13};
		System.out.println(process(arr, 0, arr.length - 1));
	}

}
