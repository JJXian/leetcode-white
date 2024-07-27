package com.xian.Z2树.JZ86在二叉树中找到两个节点的最近公共祖先;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        int res = Solution.lowestCommonAncestor(root,6,2);
        System.out.println(res);

    }
    public  static  int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if(root == null){
            return -1;
        }
        if(root.val == o1|| root.val == o2){
            return root.val;
        }

        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        if(left != -1 && right != -1){
            return root.val;
        }
        return left != -1? left : right;

    }


}
