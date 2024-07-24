package com.xian.Z2树.JZ55二叉树的深度;


import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
         if(root == null){
             return 0;
         }
         int leftDepth = TreeDepth(root.left);
         int rightDepth = TreeDepth(root.right);
         return Math.max(leftDepth,rightDepth) +1;
    }
}
