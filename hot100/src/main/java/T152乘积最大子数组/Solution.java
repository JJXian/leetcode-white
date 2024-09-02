package T152乘积最大子数组;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        int res = maxProduct(nums);
        System.out.println(res);
    }

    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int maxNum = nums[0];
        int minNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
//            当前元素小于0 交换最大最小的 然后乘起来
            if (nums[i] < 0) {
                int temp = maxNum;
                maxNum = minNum;
                minNum = temp;
            }
            maxNum = Math.max(maxNum * num, num);
            minNum = Math.min(minNum * num, num);
            res = Math.max(res, maxNum);
        }
        return res;
    }
}
