package com.xian.Z1链表.JZ76删除链表中重复的结点;

import com.xian.Z1链表.ListNode;

/**
 * @Author: jjxian
 */
public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {
        // 创建一个哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;

        ListNode prev = dummy;
        ListNode current = pHead;

        while (current != null) {
            // 如果当前节点和下一个节点值相同
            boolean isDuplicate = false;
            while (current.next != null && current.next.val == current.val) {
                current = current.next;
                isDuplicate = true;
            }
            if (isDuplicate) {
                // 跳过所有重复节点
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            // 向前移动current指针
            current = current.next;
        }

        return dummy.next;
    }
}
