package com.xian.Z10其他算法.JZ39数组中出现次数超过一半的数字;

import java.util.Arrays;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int x = so.MoreThanHalfNum_Solution(array);
        System.out.println(x);
    }

    public int MoreThanHalfNum_Solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }
}
