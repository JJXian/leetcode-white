package com.xian.Z2树.JZ86在二叉树中找到两个节点的最近公共祖先;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution2 {

    public int findAncetor(TreeNode root, int o1, int o2) {
        if (root == null) {
            return -1;
        }

        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = findAncetor(root.left, o1, o2);
        int right = findAncetor(root.right, o1, o2);

        if (left != -1 && right != -1) {
            return root.val;
        }
        return left != -1 ? left : right;
    }


}
