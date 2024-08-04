package com.xian.Z10其他算法.JZ43整数中1出现的次数;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.NumberOf1Between1AndN_Solution(13);
        System.out.println(res);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }
}
