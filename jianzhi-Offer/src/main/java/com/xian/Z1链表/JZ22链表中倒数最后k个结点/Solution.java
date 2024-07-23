package com.xian.Z1链表.JZ22链表中倒数最后k个结点;

import com.xian.Z1链表.ListNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        // 构建链表测试用例
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // 要查找的倒数第k个节点
        ListNode result = getKthFromEnd(head, k);
        if (result != null) {
            System.out.println("The value of the kth node from the end is: " + result.val);
        } else {
            System.out.println("The list is shorter than " + k + " nodes.");
        }
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        // 移动 fast 指针 k 步
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // 链表长度小于 k
            }
            fast = fast.next;
        }

        // 同时移动 fast 和 slow 指针，直到 fast 到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
