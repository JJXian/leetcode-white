package com.xian.Z1链表;


/**
 * 链表节点
 * @Author: jjxian
 */
public class ListNode {
    public int val;
    public ListNode next;

    public  ListNode(){

    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val,ListNode next){
        this.val =val;
        this.next = next;
    }
}
