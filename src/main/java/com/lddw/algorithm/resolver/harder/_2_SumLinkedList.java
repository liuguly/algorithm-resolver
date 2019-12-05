package com.lddw.algorithm.resolver.harder;

/**
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author LiuXin
 * @date 2019/12/5 11:08
 * @since 1.0
 **/
public class _2_SumLinkedList {

   static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode((l1.val + l2.val));
        ListNode newNode = null;
        while(l1!=null && l2!=null){
            if(l1.next ==null || l2.next == null) {
                newNode = new ListNode(l1.val + l2.val);
                currentNode.next = newNode;
                break;
            }
            newNode = new ListNode(l1.next.val + l2.next.val);
            l1 = l1.next;
            l2 = l2.next;
            currentNode.next = newNode;
        }
        return currentNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(7);

        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(2);

        ListNode listNode2 = addTwoNumbers(listNode,listNode1);

        while(listNode2 !=null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }

}
