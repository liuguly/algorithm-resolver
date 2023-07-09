package com.lddw.algorithm.resolver.link;

/**
 * 反转单项和双向链表
 */
public class Link4 {

    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            //取到下一个节点
            next = head.next;
            //把下一个节点设置为上一个
            head.next = pre;
            //上一个节点设置成当前节点
            pre = head;
            //把下一个节点设置成当前节点
            head = next;
        }
        return pre;
    }

    public DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head !=null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }



}
