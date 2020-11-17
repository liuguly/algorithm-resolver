package com.lddw.algorithm.resolver.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

public class MergeSort {

    public static void sortProcess(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int mid = L +((R-L) >> 1);
        mid = (L + R)/2;
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{7,4,8,3,10,12,13,11};
        sortProcess(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    public static void merge(int[] arr,int L, int mid,int R){
        int[] help = new int[R -L +1];
        int i=0;
        int p1 = L;
        int p2 = mid +1;
        while(p1 <= mid && p2 <= R){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }

        while(p1 <=mid){
            help[i++] = arr[p1++];
        }

        while(p2 <=R){
            help[i++] = arr[p2++];
        }

        for(i =0;i<help.length;i++){
            arr[L +i] = help[i];
        }
    }


}
