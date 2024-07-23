package com.xian.Z1链表.JZ25合并两个排序的链表;

import com.xian.Z1链表.ListNode;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //       构建链表

        // 构建第一个链表
        System.out.println("Input the values for the first linked list, end with a non-integer:");
        ListNode node1 = createLinkedList(sc);

        // 构建第二个链表
        System.out.println("Input the values for the second linked list, end with a non-integer:");
        ListNode node2 = createLinkedList(sc);

        ListNode res = merge(node1,node2);
        ListNode t = res;
        while(t!= null){
            System.out.println(t.val);
            t = t.next;
        }
    }

    public static ListNode merge(ListNode pHead1,ListNode pHead2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode node1 = pHead1,node2 = pHead2,temp;
//        小节点合并到dummy
        while(node1!=null && node2!=null){
            if(node1.val > node2.val){
                temp = node2.next;
                node2.next = tail;
                tail.next = node2;
                tail = node2;
                node2 = temp;
            }else{
                temp = node1.next;
                node1.next = tail;
                tail.next = node1;
                tail = node1;
                node1 = temp;
            }
        }
//        未合并完继续合并
        if(node1 != null){
            tail.next = node1;
        }
        if(node2!=null){
            tail.next = node2;

        }
        return dummy.next;

    }
//  创建链表
    private static   ListNode createLinkedList(Scanner sc) {
        ListNode dummy = new ListNode(); // 哑结点
        ListNode tail = dummy;

        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            ListNode curNode = new ListNode(val);
            tail.next = curNode;
            tail = curNode;
        }

        // 清除缓冲区中的非整数输入
        if (sc.hasNext()) {
            sc.next();
        }

        return dummy.next;
    }
}
