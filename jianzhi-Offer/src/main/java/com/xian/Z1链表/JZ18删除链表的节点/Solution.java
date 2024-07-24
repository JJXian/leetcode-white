package com.xian.Z1链表.JZ18删除链表的节点;

import com.xian.Z1链表.ListNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public ListNode deleteNode (ListNode head, int val) {

        ListNode dummy = new ListNode();
        if(head.val == val){
            dummy.next = head.next;
            return dummy.next;
        }
        dummy.next = head;
        ListNode curNode = head,pre = dummy;
        while(curNode != null){
            if(curNode.val == val){
                pre.next = curNode.next;
                curNode.next = null;
                break;
            }else {
                pre = curNode;
                curNode = curNode.next;
            }

        }
        return head;
    }
}
