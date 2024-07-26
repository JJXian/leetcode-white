package com.xian.Z2树.JZ8二叉树的下一个结点;

/**
 * @Author: jjxian
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return pNode;
        }

//        情况1 树有右子树 下一个中序遍历节点就是当前节点右子树中最左的节点
        if(pNode.right != null){
            return findLeftMost(pNode.right);
        }

//        情况2 如果是根节点 一直往上找，如果当前节点是 parent 的左子节点，那么下一个中序遍历的节点就是 parent。
        TreeLinkNode parent = pNode.next;
        while(parent != null && pNode == parent.right){
            pNode = parent;
            parent = parent.next;
        }
        return parent;



    }

    public TreeLinkNode findLeftMost(TreeLinkNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
