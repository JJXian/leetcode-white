package com.xian.Z2树.JZ7重建二叉树;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solution {
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        return buildTree(preOrder,0,preOrder.length-1,vinOrder,0,vinOrder.length-1);
    }

    public TreeNode buildTree(int[] preOrder, int preStart,int preEnd, int[] vinOrder, int vinStart, int vinEnd){
//       终止条件
        if (preStart > preEnd || vinStart > vinEnd) {
            return null;
        }

        int rootVal = preOrder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        while(vinOrder[rootIndex] != rootVal){
            rootIndex++;
        }
        // 计算左子树的节点数
        int leftTreeSize = rootIndex - vinStart;


        root.left = buildTree(preOrder,preStart+1,preStart+leftTreeSize,vinOrder,vinStart,rootIndex-1);
        root.right = buildTree(preOrder,preStart+leftTreeSize+1,preEnd,vinOrder,rootIndex+1,vinEnd);
        return root;
    }
}
