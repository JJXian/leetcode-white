package com.xian.T53最大子数组和;

/**
 * @Author: jjxian
 */
class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = so.maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
            }
        }
        return dp[n - 1];
    }
}