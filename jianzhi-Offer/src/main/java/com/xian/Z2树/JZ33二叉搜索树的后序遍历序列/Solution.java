package com.xian.Z2树.JZ33二叉搜索树的后序遍历序列;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] sequence = new int[]{5,7,6,9,11,10,8};
        boolean res = VerifySquenceOfBST(sequence);
        System.out.println(res);

    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
//      题目要求空树不是二叉搜索树
        if (sequence == null || sequence.length == 0) {
            return true;
        }
        return VerifySquenceOFBST(sequence, 0, sequence.length - 1);

    }

    public static boolean VerifySquenceOFBST(int[] sequence, int start,int end){
        if(start >= end){
            return true; //说明这个子数组只有一个节点或者没有节点，直接返回 true
        }

        // 当前子树的根节点值
        int rootVal = sequence[end];
        int i = start;
        // 找到第一个大于根节点的值，它之后的所有值应该属于右子树
        while(i<end && sequence[i] <rootVal){
            i++;
        }
        int rightStart = i;
        // 验证右子树的所有节点是否都大于根节点
        while(i<end){
            if(sequence[i] < rootVal){
                return false;
            }
            i++;
        }
        // 递归验证左子树和右子树
        return VerifySquenceOFBST(sequence, start, rightStart - 1) &&
                VerifySquenceOFBST(sequence, rightStart, end - 1);

    }
}
