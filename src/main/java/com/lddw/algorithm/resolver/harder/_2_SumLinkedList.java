package com.lddw.algorithm.resolver.harder;

/**
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 示例： 输入：(2 ->
 * 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807 来源：力扣（LeetCode）
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

        ListNode(final int x) {
            val = x;
        }
    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode dNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dNode.next;
    }


    public static ListNode addTwoNumLinked(ListNode l1, ListNode l2) {
        ListNode dNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode currListNode = dNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            currListNode.next = new ListNode(sum % 10);
            currListNode = currListNode.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            if (carry > 0) {
                currListNode.next = new ListNode(carry);
            }
        }
        return dNode.next;
    }

    public static void main(final String[] args) {
        final ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        final ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);

        ListNode result = addTwoNum(listNode, listNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}