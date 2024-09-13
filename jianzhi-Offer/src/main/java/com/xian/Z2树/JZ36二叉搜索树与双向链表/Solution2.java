package com.xian.Z2树.JZ36二叉搜索树与双向链表;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution2 {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if (pre == null) {
            head = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
        }
        pre = pre.right;

        Convert(pRootOfTree.right);
        return head;

    }

}


