package com.xian.Z4搜索算法.JZ11旋转数组的最小数字;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int min = findMin(nums);
        System.out.println(min);
    }


    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }
}
