package xian.bishi.bilibili0817.T3添加正负号;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            int res = helper(nums, m);
            System.out.println(res);
        }
    }


    public static void dfs(int index, int sum) {
        
    }


    public static int helper(int[] nums, int m) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 因为要用上所有的数字，dp数组大小设为 sum + 1
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            // 为避免重复计算，倒序遍历
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[i]) {
                int currentResult = i - (sum - i);
                minDiff = Math.min(minDiff, Math.abs(currentResult - m));
            }
        }

        return minDiff;
    }
}
