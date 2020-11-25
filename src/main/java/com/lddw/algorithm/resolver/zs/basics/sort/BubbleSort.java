package com.lddw.algorithm.resolver.zs.basics.sort;

/**
 * <p>描述 TODO</p>
 *
 * @author LiuXin
 * @date 2020/11/25 15:20
 * @since 1.0
 **/
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }

        /**
         * 从0开始，依次与后面比较，比较n-1次，然后与n-1位置交换
         * 从0开始，依次与后面比较，比较n-2次，然后与n-2位置交换
         * 从0开始，依次与后面比较，比较n-3次，然后与n-3位置交换
         * 。。。。。。。。。。。。。。。。。。。。。。。。。。。。
         * 所以这里限定循环范围 0 ~ n-1 依次递减
         */
        for(int e = arr.length - 1; e>0 ;e--){
            //每循环一轮e减少一次，i < e也即最右边的位置排除在外
            for(int i=0; i<e ;i++){
                if(arr[i] > arr[i+1]){
                    swap(arr,i, i+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        //异或 相同为0， 0与任务数异或为任何数
        int a = 1;
        int b = 123;
        //异或 不同为1 相同为0
        System.out.println(a^b);
    }

}
