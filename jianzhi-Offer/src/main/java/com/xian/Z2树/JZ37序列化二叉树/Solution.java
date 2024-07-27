package com.xian.Z2树.JZ37序列化二叉树;

import com.xian.Z2树.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: jjxian
 */
public class Solution {

    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        SerializeHelper(root,sb);
        return sb.toString();
    }

    /**
     * 序列化辅助函数
     * @param root
     * @param sb
     */
    public void SerializeHelper(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return ;
        }
        sb.append(root.val).append(",");
        SerializeHelper(root.left,sb);
        SerializeHelper(root.right,sb);
    }


    public TreeNode Deserialize(String str) {
//        序列字符串按照 ， 分割
        String[] nodes = str.split(",");
//        将字符串转成链表
        LinkedList<String> nodeList = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(nodeList);
    }

    /**
     * 根据序列化的字符串，按顺序重建二叉树。如果遇到 #，则表示当前节点为空，否则创建节点并递归构建其左右子树。
     * @param nodeList
     * @return
     */
    private TreeNode deserializeHelper(LinkedList<String> nodeList) {
        if(nodeList.isEmpty()){
            return null;
        }

        String val = nodeList.poll();
        if(val.equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(nodeList);
        root.right = deserializeHelper(nodeList);
        return root;
    }
}
