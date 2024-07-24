package com.xian.Z2树.JZ54二叉搜索树的第k个节点;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    int count = 0;
    int res = -1;
    public int KthNode (TreeNode proot, int k) {
        if(proot == null){
            return -1;
        }
        findK(proot,k);
        return res;
    }

    public void findK(TreeNode root, int k){
        if (root == null || count >= k) {
            return;
        }
        findK(root.left,k);
        count++;
        if(count == k){
            res = root.val;
            return ;
        }
        findK(root.right,k);
    }
}
