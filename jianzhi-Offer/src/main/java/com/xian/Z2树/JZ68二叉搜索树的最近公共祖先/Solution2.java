package com.xian.Z2树.JZ68二叉搜索树的最近公共祖先;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {

        if (root == null) {
            return -1;
        }

        if (p < root.val && q < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p > root.val && q > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root.val;


    }
}
