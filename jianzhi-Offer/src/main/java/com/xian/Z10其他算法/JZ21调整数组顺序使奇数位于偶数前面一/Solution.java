package com.xian.Z10其他算法.JZ21调整数组顺序使奇数位于偶数前面一;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] array = new int[]{1, 2, 3, 4};
        int[] res = so.reOrderArray2(array);
        for (int x : res) {
            System.out.println(x);
        }
    }

    //    进阶 空间O（1） 时间O(n2)
    public int[] reOrderArray2(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        // 使用插入排序的思路
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                int j = i;
                int temp = array[i];
                // 将奇数插入到前面的奇数段的末尾
                while (j > 0 && array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
        return array;


    }

    //    空间O(n) 时间O（n）
    public int[] reOrderArray(int[] array) {
        int[] res = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                res[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                res[index++] = array[i];
            }
        }
        return res;
    }
}
