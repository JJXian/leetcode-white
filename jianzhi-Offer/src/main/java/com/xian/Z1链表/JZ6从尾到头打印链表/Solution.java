package com.xian.Z1链表.JZ6从尾到头打印链表;

import com.xian.Z1链表.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
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
        List<Integer> res = printListFromTailToHead(node.next);
        System.out.println("the res is :" + res);

    }

     public static List<Integer> printListFromTailToHead(ListNode listNode){
        List<Integer> res = new ArrayList<>();
//        虚拟头节点
        ListNode dummy = new ListNode();
//         逆置链表
        ListNode currentNode = listNode,temp;

        while(currentNode!=null){
            temp = currentNode.next;
            currentNode.next = dummy.next;
            dummy.next = currentNode;
            currentNode = temp;

        }
        currentNode = dummy.next;
        while(currentNode!=null){
            res.add(currentNode.val);
            currentNode = currentNode.next;
        }

        return res;
     }

}
