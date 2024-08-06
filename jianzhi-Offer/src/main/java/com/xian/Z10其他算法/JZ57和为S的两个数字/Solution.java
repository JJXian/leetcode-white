package com.xian.Z10其他算法.JZ57和为S的两个数字;

import java.util.ArrayList;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] array = new int[]{1, 2, 4, 7, 11, 15};

        ArrayList<Integer> res = so.FindNumbersWithSum(array, 15);
        System.out.println(res);

    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int pre = 0, last = array.length - 1;
        while (pre < last) {
            if (array[pre] + array[last] == sum) {
                res.add(array[pre]);
                res.add(array[last]);
                return res;
            } else if (array[pre] + array[last] < sum) {
                pre++;
            } else {
                last--;
            }
        }
        return res;
    }
}
