package com.lddw.algorithm.resolver.link;

/**
 * 反转链表的部分节点
 */
public class Link5 {

    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        //fPre就是from得前一个节点
        Node fPre = null;
        //tPos就是to得后一个节点
        Node tPos = null;
        while (node1 != null) {
            len++;
            //找到前一个节点
            fPre = len == from - 1 ? node1 : fPre;
            //找到后一个节点
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        //如果fPre为null,说明反转部分是包含头节点得，则返回新得头节点，也就是没反转之前反转部分的最后一个节点，也是反转之后反转部分的第一个节点；如果fPre不为null，则返回旧的头节点。
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }


    public static void main(String[] args) {
        Link5 link5 = new Link5();
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node result = link5.reversePart(node, 2, 3);
        int i = 0;
        while (result != null) {
            i++;
            System.out.println(result.value);
            result = result.next;
        }

    }

}
