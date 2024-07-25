package com.xian.Z2树.JZ27二叉树的镜像;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public TreeNode Mirror(TreeNode pRoot){
//        树为空 返回null
        if(pRoot == null){
            return null;
        }
//        交换左右子树
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
//        递归镜像左右子树
        pRoot.left = Mirror(pRoot.left);
        pRoot.right = Mirror(pRoot.right);
//        返回根
        return pRoot;
    }
}
