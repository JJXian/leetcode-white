package com.xian.Z8位运算.JZ15二进制中1的个数;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int x = so.NumberOf1(-1);
        System.out.println(x);
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }
}
