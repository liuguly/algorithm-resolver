package com.lddw.algorithm.resolver.zs.basics.sort;

/**
 * <p>描述 TODO</p>
 *
 * @author LiuXin
 * @date 2020/11/25 15:04
 * @since 1.0
 **/
public class SelectionSort {

    /**
     * 选择排序
     * 从0开始一直到n-1，查找最小值，然后与0位置交换
     * 从1开始一直到n-1，查找最小值，然后与1位置交换
     * 从2开始一直到n-1，查找最小值，然后与2位置交换
     * 。。。。。。。。。。。。。。。。。。。。。。。
     *
     * 时间复杂度：  查看次数 n + n-1 + n-2 + n-3 +....
     *             比较次数 n + n-1 + n-2 + n-3 +....
     *             交换次数 n次
     *             最终公式 aN~2 +bN + c
     * 不要高阶项，也不要低阶项目，也不要高阶项目系数，那么剩下的f(n)，记做时间复杂度o(fn)
     * @param arr 数组
     */
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //i ~ N-1 限定范围
        for(int i=0; i<arr.length-1; i++){
            //最小值的位置，暂定为i
            int minIndex = i;
            //i ~ N-1 上找最小值的下标
            for(int j=i+1; j<arr.length; j++){
                //如果下个位置小于当前，那么赋值最小下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
