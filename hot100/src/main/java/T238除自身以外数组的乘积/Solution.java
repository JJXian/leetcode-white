package T238除自身以外数组的乘积;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution so = new Solution();

        int[] res = so.productExceptSelf(nums);
        for (int num : res) {
            System.out.println(num);
        }

    }

    public int[] productExceptSelf(int[] nums) {
        // 前缀积 和 后缀积
        int n = nums.length;
        int[] answer = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        int[] postfix = new int[n];
        postfix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            postfix[n - i - 1] = postfix[n - i] * nums[n - i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                answer[i] = postfix[i + 1];
            } else if (i == n - 1) {
                answer[i] = prefix[i - 1];
            } else {
                answer[i] = prefix[i - 1] * postfix[i + 1];
            }

        }
        return answer;

    }
}
