package com.xian.Z2树.JZ79判断是不是平衡二叉树;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        int leftDepth = depth(pRoot.left);
        int rightDepth = depth(pRoot.right);

        if(Math.abs(leftDepth-rightDepth) > 1){
            return false;
        }

        boolean left = IsBalanced_Solution(pRoot.left);
        boolean right = IsBalanced_Solution(pRoot.right);

        return left && right;

    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDep = depth(root.left);
        int rightDep = depth(root.right);

        return Math.max(leftDep,rightDep) +1;
    }
}
