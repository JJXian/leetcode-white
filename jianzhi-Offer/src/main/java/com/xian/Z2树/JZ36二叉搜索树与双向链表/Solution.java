package com.xian.Z2树.JZ36二叉搜索树与双向链表;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    private TreeNode prev = null;  // 指向上一个访问过的节点
    private TreeNode head = null;  // 指向双向链表的头节点

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }

        // 中序遍历：先转换左子树
        Convert(pRootOfTree.left);
        if(prev == null){
            head = pRootOfTree;
        }else{
            // 否则，将当前节点与上一个节点连接
            prev.right = pRootOfTree;
            pRootOfTree.left = prev;
        }
        prev = pRootOfTree;


        Convert(pRootOfTree.right);
        return head;
    }

}
