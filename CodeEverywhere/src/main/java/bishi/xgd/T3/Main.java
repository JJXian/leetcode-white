package bishi.xgd.T3;

import java.util.Arrays;

/**
 * @Author: jjxian
 */
public class Main {

    /**
     * 最佳分类
     * 给定一个数组，如果两个数差的绝对值小于等于一个给定的数则两个数在一组，如果一个数与该组的所有数的平均值的差绝对值小于给定的数，则该数可分配到该组。求给定的数组最小可以划分成多少组。
     * <p>
     * 要求：数组长度n满足  0<n<1000   数组值m的大小满足 0< m < 10000.
     */
    public static int minGroups(int[] nums, int maxDiff) {
        Arrays.sort(nums);
        int n = nums.length;
        int groupCount = 0;
        int i = 0;

        while (i < n) {
            groupCount++;
            int sum = nums[i];
            int count = 1;
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= maxDiff) {
                double avg = (double) sum / count;
                if (Math.abs(nums[j] - avg) <= maxDiff) {
                    sum += nums[j];
                    count++;
                    j++;
                } else {
                    break;
                }
            }
            i = j;
        }

        return groupCount;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 9, 10};
        int[] nums = {2, 3, 8, 10, 17, 19};
        int maxDiff = 5;
        int result = minGroups(nums, maxDiff);
        System.out.println("最小分组数：" + result);  // Output: 最小分组数：2
    }
}
