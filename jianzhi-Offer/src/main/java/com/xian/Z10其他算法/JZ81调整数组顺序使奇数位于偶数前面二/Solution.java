package com.xian.Z10其他算法.JZ81调整数组顺序使奇数位于偶数前面二;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] array = new int[]{1, 2, 3, 4};
        int[] nums = so.reOrderArrayTwo(array);
        for (int x : nums) {
            System.out.println(x);
        }
    }

    public int[] reOrderArrayTwo(int[] array) {
//        前指针遍历到偶数 遍历尾指针到奇数 然后交换
        int pre = 0, last = array.length - 1;
        while (pre < last) {
            while (pre < last && array[pre] % 2 == 1) {
                pre++;
            }
            while (pre < last && array[last] % 2 == 0) {
                last--;
            }
            int temp = array[pre];
            array[pre] = array[last];
            array[last] = temp;
        }
        return array;
    }
}
