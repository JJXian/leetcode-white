package com.xian.Z1链表.JZ35复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jjxian
 */
public class Solution {

    Map<RandomListNode,RandomListNode> map = new HashMap<>();

    /**
     * 方法一 递归赋值
     * @param head
     * @return
     */
//    public RandomListNode Clone(RandomListNode pHead) {
//        if(pHead == null){
//            return null;
//        }
//
//        if(!map.containsKey(pHead)){
//            RandomListNode node = new RandomListNode(pHead.label);
//            map.put(pHead,node);
//            node.next = Clone(pHead.next);
//            node.random = Clone(pHead.random);
//        }
//        return map.get(pHead);
//
//    }


    /**
     * 方法2
     * 1.	第一步：克隆节点并插入到原节点后面
     * 	•	遍历原链表，对于每个节点，创建一个新的克隆节点，将其插入到原节点后面。这样，链表结构将变成：A -> A' -> B -> B' -> C -> C' -> ...。
     * 	2.	第二步：复制随机指针
     * 	•	再次遍历链表，对于每个原节点，设置克隆节点的 random 指针。cloneNode.random = originalNode.random.next。
     * 	3.	第三步：分离两个链表
     * 	•	最后，拆分链表，将克隆节点从原链表中分离出来，恢复原链表，并形成一个独立的克隆链表。
     * @param head
     * @return
     */
    public RandomListNode Clone(RandomListNode head){
        if (head == null) {
            return null;
        }

        // 第一步：克隆节点并插入到原节点后面
        RandomListNode current = head;
        while(current != null){
            RandomListNode newNode = new RandomListNode(current.label);
            newNode.next = current.next ;
            current.next = newNode;
            current = newNode.next;
        }

        // 第二步：复制随机指针
        current = head;
        while(current != null){
//            current 始终指向原来的节点
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // 第三步：分离两个链表
        current = head;
        RandomListNode cloneHead = head.next;
        RandomListNode copy = cloneHead;
        while(current != null){
            current.next = current.next.next;
            if(copy.next != null){// 将复制的节点连接到下一个复制的节点
                copy.next = copy.next.next;
            }
            current = current.next;
            copy = copy.next;
        }

        return cloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}