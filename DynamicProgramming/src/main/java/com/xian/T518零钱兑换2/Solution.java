package com.xian.T518零钱兑换2;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int res = so.change(amount, coins);
        System.out.println(res);

    }

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
