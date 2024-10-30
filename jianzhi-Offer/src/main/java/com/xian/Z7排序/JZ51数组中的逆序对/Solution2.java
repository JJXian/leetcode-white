package com.xian.Z7排序.JZ51数组中的逆序对;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};

        int res = countNiXuDui(nums);
        System.out.println(res);

    }

    public static int countNiXuDui(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
