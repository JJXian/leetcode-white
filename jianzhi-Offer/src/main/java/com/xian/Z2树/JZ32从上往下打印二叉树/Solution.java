package com.xian.Z2树.JZ32从上往下打印二叉树;

import com.xian.Z2树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: jjxian
 */
public class Solution {
    public ArrayList<Integer> printFromUpToDown(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //        辅助队列 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //        遍历
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0 ;i<size;i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;

    }
}
