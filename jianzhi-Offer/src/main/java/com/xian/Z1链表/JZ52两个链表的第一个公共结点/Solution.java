package com.xian.Z1链表.JZ52两个链表的第一个公共结点;

import com.xian.Z1链表.ListNode;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        // 构建链表测试用例
        ListNode common = new ListNode(6);
        common.next = new ListNode(7);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = common;

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = common;

        ListNode result = getIntersectionNode(head1, head2);
        if (result != null) {
            System.out.println("The first common node value is: " + result.val);
        } else {
            System.out.println("There is no common node.");
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 计算两个链表的长度
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        // 将较长的链表向前移动
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        // 同时遍历两个链表，找到第一个公共节点
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }


    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
