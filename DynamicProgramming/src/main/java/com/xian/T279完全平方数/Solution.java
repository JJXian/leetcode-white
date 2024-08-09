package com.xian.T279完全平方数;

/**
 * @Author: jjxian
 */
class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();

        int x = so.numSquares(1);
        System.out.println(x);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = max;
        }
        // 先遍历物品 再遍历背包
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
