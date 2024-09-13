package com.xian.Z2树.JZ33二叉搜索树的后序遍历序列;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return testBST(sequence, 0, sequence.length - 1);
    }

    public static boolean testBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true; //说明这个子数组只有一个节点或者没有节点，直接返回 true
        }

        int rootVal = sequence[end];
        int i = start;
        while (i < end && sequence[i] < rootVal) {
            i++;
        }
        int rightStart = i;
        while (i < end) {
            if (sequence[i] < rootVal) {
                return false;
            }
            i++;
        }
        // 递归验证左子树和右子树
        return testBST(sequence, start, rightStart - 1) &&
                testBST(sequence, rightStart, end - 1);


    }
}

