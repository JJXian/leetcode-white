package com.xian.Z2树.JZ8二叉树的下一个结点;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return pNode;
        }

//        如果有右孩子 直接返回右子树中最左的节点
        if (pNode.right != null) {
            TreeLinkNode node = findMostLeft(pNode.right);
            return node;
        }
//        如果是根节点 往上找根节点  当前节点是根节点的左节点 就找到中序遍历的下一个节点
        TreeLinkNode parent = pNode.next;
        while (parent != null && parent.left != pNode) {
            pNode = parent;
            parent = pNode.next;
        }
        return pNode;

    }

    public TreeLinkNode findMostLeft(TreeLinkNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
