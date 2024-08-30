package T45跳跃游戏2;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Solution so = new Solution();
        int res = so.jump(nums);
        System.out.println(res);
    }

    public int jump(int[] nums) {
        int maxRange = nums[0];
        int max = maxRange;
        int times = 1;
        for (int i = 0; i < nums.length; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (i == max) {
                max = maxRange;
                times++;
            }

        }

        return times;
    }
}
