package com.xian.Z1链表.JZ24反转链表;

import com.xian.Z1链表.ListNode;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
//       构建链表
        ListNode node = new ListNode();
        ListNode tail = node;
        System.out.println("input the num of node ,以任意字符结束:");
        while(sc.hasNextInt()){
            int val = sc.nextInt();
            ListNode curNode = new ListNode(val);
            curNode.next = tail.next;
            tail.next = curNode;
            tail = curNode;
        }
        ListNode list = reverse(node);
        ListNode cur = list;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }


    }

    public static ListNode reverse(ListNode list){
        ListNode dummy = new ListNode();
        ListNode curNode = list,temp;

        while(curNode != null){
            temp = curNode.next;
            curNode.next = dummy.next;
            dummy.next = curNode;
            curNode = temp;
        }
        return dummy.next;

    }
}
