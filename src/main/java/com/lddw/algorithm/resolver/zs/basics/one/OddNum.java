package com.lddw.algorithm.resolver.zs.basics.one;

/**
 * <p>描述 TODO</p>
 *
 * @author LiuXin
 * @date 2020/11/25 16:59
 * @since 1.0
 **/
public class OddNum {

	public static void printOddNum(int[] arr) {
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		//& 相同取1 不同取0
		int rightOne = eor & (~eor + 1);
		int onlyOne = 0;
		for (int cur : arr) {
			if ((cur & rightOne) == 0) {
				onlyOne ^= cur;
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 7;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		//异或 相同为0， 0与任务数异或为任何数

		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}


}
