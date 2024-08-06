package com.xian.Z10其他算法.JZ17打印从1到最大的n位数;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] res = so.printNumbers(3);
        for (int x : res) {
            System.out.println(x);
        }
    }

    public int[] printNumbers(int n) {
        int[] res = new int[(int) (Math.pow(10, n) - 1)];
        for (int i = 1; i <= res.length; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
