package com.xian.Z10其他算法.JZ83剪绳子进阶版;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        long res = so.cutRope(874520);
        System.out.println(res);
    }

    static final long MOD = 998244353;

    public long cutRope(long n) {
        if (n <= 3) {
            return n - 1;
        }

        long res = 1;
        while (n > 4) {
            res = res * 3 % MOD;
            n -= 3;
        }
        return res * n % MOD;
    }
}
