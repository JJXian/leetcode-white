package com.xian.Z1链表.JZ23链表中环的入口结点;

import com.xian.Z1链表.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: jjxian
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        Set集合存node 再次遍历到就是环的入口
        Set<ListNode> set = new HashSet<>();
        ListNode node = pHead;
        while(node !=null){
            if(set.contains(node)){
                return node;
            }else{
                set.add(node);
            }
            node = node.next;
        }
        return null;



    }
//以下是判断是否有环
        //        if(pHead == null){
//            return null;
//        }
////        快指针每次移动2个 慢指针移动一个 有环的话会相遇
//        ListNode fast = pHead.next;
//        ListNode slow = pHead;
//        while(fast!=null && slow != null){
//            if(fast == slow){
//                return fast;
//            }
//            fast = fast.next;
//            if(fast!=null){
//                fast = fast.next;
//            }
//            slow = slow.next;
//        }
//        return null;
//    }

}
