package com.lddw.algorithm.resolver.link;

public class Link2 {

    /**
     * 单链表删除倒数第k个节点
     *
     * @param head    头节点
     * @param lastKth 第k个节点
     * @return node
     */
    public Node removeLastKthNode(Node head, int lastKth) {
        //如果为空或者小于1，那么直接返回头节点
        if (head == null || lastKth < 1) {
            return head;
        }

        //循环完毕，查看lastKth的值
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        //如果等于0表示倒数第k个节点就是头节点
        if (lastKth == 0) {
            head = head.next;
        }

        //如果小于零，递增lastKth，直到为0，那么当前cur就是要删除节点的前一个节点，那么把cur的next链接为cur.next.next即可
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }

        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }


}
