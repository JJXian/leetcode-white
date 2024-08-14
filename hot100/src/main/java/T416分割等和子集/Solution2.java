package T416分割等和子集;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 so = new Solution2();
        int[] nums = {1, 5, 11, 5};
        so.canPartition(nums);
    }

    public boolean canPartition(int[] nums) {
        // 转换成01背包问题
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 奇数的话无法分割
        if (sum % 2 == 1) {
            return false;
        }
        // 偶数目标找一半
        int target = sum / 2;
        // 前i个数字能组成的和
        int[] dp = new int[target];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }
        return dp[target - 1] == target;
    }
}
