package com.xian.Z2树;

/**
 * @Author: jjxian
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
