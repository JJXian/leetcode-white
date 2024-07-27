package com.xian.Z2树.JZ68二叉搜索树的最近公共祖先;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if(root == null){
            return -1;
        }
        if(root.val == p || root.val == q){
            return root.val;
        }

        int left = lowestCommonAncestor(root.left,p,q);
        int right = lowestCommonAncestor(root.right, p,q);


        if(left == -1 && right == -1){
            return -1;
        }else if(left != -1 && right == -1){
            return left;
        }else if(left == -1 && right != -1){
            return right;
        }else {
            return root.val;
        }
    }

    public int LCA(TreeNode root, int p,int q){
        if (root == null) {
            return -1;
        }

        // 如果 p 和 q 都小于当前节点，向左子树查找
        if (p < root.val && q < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // 如果 p 和 q 都大于当前节点，向右子树查找
        if (p > root.val && q > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // 如果 p 和 q 分别位于当前节点的两侧，或者其中一个是当前节点
        return root.val;

    }
}
