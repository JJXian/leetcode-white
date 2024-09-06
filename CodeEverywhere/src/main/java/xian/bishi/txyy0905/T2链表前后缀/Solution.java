package xian.bishi.txyy0905.T2链表前后缀;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode tail = a;
        tail.next = new ListNode(2);
        tail = tail.next;
        tail.next = new ListNode(2);
        tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;
        tail.next = new ListNode(4);

        ListNode b = new ListNode(1);
        tail = b;
        tail.next = new ListNode(2);
        tail = tail.next;
        tail.next = new ListNode(1);
        tail = tail.next;
        tail.next = new ListNode(2);
        tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;
        tail.next = new ListNode(4);
        tail = tail.next;


    }

    /**
     * 提交答案
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeList2(ListNode a, ListNode b) {
        ListNode t = a;
        int lenA = 0, lenB = 0;
        while (t != null) {
            t = t.next;
            lenA++;
        }
        t = b;
        while (t != null) {
            t = t.next;
            lenB++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode tail = dummy;
        ListNode curA = a, curB = b;
        while (curA.val == curB.val) {

            ListNode node = new ListNode(curA.val);
            node.next = tail.next;
            tail.next = node;
            tail = node;
            curA = curA.next;
            curB = curB.next;
        }

        //        长的指针先走cha步
        if (lenA > lenB) {
            int cha = lenA - lenB;
            for (int i = 0; i < cha; i++) {
                curA = curA.next;
            }
        } else {
            int cha = lenB - lenA;
            for (int i = 0; i < cha; i++) {
                curB = curB.next;
            }
        }
        //        走到后缀相等的第一个节点
        while (curA.val != curB.val) {
            curA = curA.next;
            curB = curB.next;
        }

        while (curA != null) {
            ListNode node = new ListNode(curA.val);
            node.next = tail.next;
            tail.next = node;
            tail = node;
            curA = curA.next;
        }
        return dummy.next;


    }

    public ListNode mergeList(ListNode a, ListNode b) {
        ListNode t = a;
        int lenA = 0, lenB = 0;
        while (t != null) {
            t = t.next;
            lenA++;
        }
        t = b;
        while (t != null) {
            t = t.next;
            lenB++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode tail = dummy;
        ListNode curA = a, curB = b;
        ListNode preA;
        // 公共前缀
        while (curA == curB) {
            preA = curA;
            curA = curA.next;
            curB = curB.next;
//            插入结果链表中
            preA.next = tail.next;
            tail.next = preA;
            tail = preA;
        }
//        长的指针先走cha步
        if (lenA > lenB) {
            int cha = lenA - lenB;
            for (int i = 0; i < cha; i++) {
                curA = curA.next;
            }
        } else {
            int cha = lenB - lenA;
            for (int i = 0; i < cha; i++) {
                curB = curB.next;
            }
        }
//        走到后缀相等的第一个节点
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        while (curA != null) {
            preA = curA;
            curA = curA.next;
            preA.next = tail.next;
            tail.next = preA;
            tail = preA;
        }
        return dummy.next;
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    public ListNode mergeList1(ListNode a, ListNode b) {
        ListNode t = a;
        int lenA = 0, lenB = 0;
        while (t != null) {
            t = t.next;
            lenA++;
        }
        t = b;
        while (t != null) {
            t = t.next;
            lenB++;
        }

        ListNode curA = a, curB = b;
        ListNode start = null;
//      找公共前缀的结束的下一个位置
        while (curA == curB) {
            start = curA;
            curA = curA.next;
            curB = curB.next;
        }
//        start.next = null;
//      找后缀开始位置 长的先走差步
        if (lenA > lenB) {
            int cha = lenA - lenB;
            for (int i = 0; i < cha; i++) {
                curA = curA.next;
            }
        } else {
            int cha = lenB - lenA;
            for (int i = 0; i < cha; i++) {
                curB = curB.next;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
//      拼接公共前后缀
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode tail = dummy;
        ListNode currentNode = a;
        dummy.next = a;
        while (currentNode.next != start) {
            currentNode = currentNode.next;
        }
        currentNode.next = curA;

        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}