package T160相交链表;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-18
 */
public class Solution {

    public static void main(String[] args) {
        ListNode headA1 = createLinkedList(new int[] {1, 2, 3, 4, 5});
        ListNode headB1 = createLinkedList(new int[] {6, 7});
        ListNode intersectionNode1 = headA1.next.next.next; // intersection at node 4
        headB1.next.next = intersectionNode1;

        System.out.println("Example 1:");
        System.out.print("List A: ");
        printLinkedList(headA1);
        System.out.print("List B: ");
        printLinkedList(headB1);


        ListNode result1 = getIntersectionNode(headA1, headB1);
        if (result1 != null) {
            System.out.println("Intersection node value: " + result1.val);
        } else {
            System.out.println("No intersection found.");
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA,nodeB;
        nodeA = headA;
        nodeB=headB;
        int lenA = 0,lenB = 0;
        while(nodeA!=null){
            nodeA = nodeA.next;
            lenA++;
        }
        while(nodeB!=null){
            nodeB = nodeB.next;
            lenB++;
        }
        nodeA=headA;
        nodeB=headB;
        if(lenA>lenB){
            int x = lenA -lenB;
            for(int i= 0;i<x;i++){
                nodeA = nodeA.next;
            }
        }else{
            int y = lenB - lenA;
            for(int i = 0;i<y;i++){
                nodeB = nodeB.next;
            }
        }

        while(nodeA!=nodeB){
            nodeA=nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print a linked list (for debugging purposes)
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        this.next = null;
    }
}