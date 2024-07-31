package com.xian.Z5动态规划.JZ46把数字翻译成字符串;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        String nums = "31717126241541717";
        int res = solve(nums);
        System.out.println(res);
    }

    public static int solve(String nums) {
        if (nums == null || nums.length() == 0 || nums.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[nums.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= nums.length(); i++) {
            //•	单字符解码: 如果 nums[i-1] 不是’0’，则 dp[i] += dp[i-1]。
            int oneDigit = Integer.parseInt(nums.substring(i - 1, i));
            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }
            //• 双字符解码: 如果 nums[i-2]nums[i-1] 组成的数值在10到26之间，则 dp[i] += dp[i-2]。
            int twoDight = Integer.parseInt(nums.substring(i - 2, i));
            if (twoDight >= 10 && twoDight <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[nums.length()];
    }
}
