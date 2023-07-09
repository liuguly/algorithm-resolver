package com.lddw.algorithm.resolver;

import org.junit.jupiter.api.Test;

public class Comp {

    public int[] lenRandomValueRandom(int maxLen, int maxValue){
        int len = (int)(Math.random() * maxLen);
        int[] ans = new int[len];
        for(int i=0; i<len; i++){
            ans[i] = (int)(Math.random() * maxValue);
        }
        return ans;
    }


    public int mostLeftNoLessNumIndex(int[] arr, int num){
        int l = 0;
        int r = arr.length - 1;

        return 1;
    }

    public Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while(head !=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class Node{
        int value;
        Node next;
        Node rand;
        Node(int val){
            value = val;
        }
    }

}
