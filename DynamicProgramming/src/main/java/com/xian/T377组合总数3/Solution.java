package com.xian.T377组合总数3;

/**
 * @Author: jjxian
 */
class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        int res = so.combinationSum4(nums, target);
        System.out.println(res);
        
    }


    public int combinationSum4(int[] nums, int target) {
        // dp[i]
        int[] dp = new int[target + 1];
        dp[0] = 1;


        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }

        }

        return dp[target];
    }
}