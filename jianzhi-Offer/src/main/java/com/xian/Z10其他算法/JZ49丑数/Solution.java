package com.xian.Z10其他算法.JZ49丑数;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.GetUglyNumber_Solution(7);
        System.out.println(res);

    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int index2 = 0, index3 = 0, index5 = 0;

        while (nextUglyIndex < index) {
            int nextUgly = Math.min(uglyNumbers[index2] * 2,
                    Math.min(uglyNumbers[index3] * 3, uglyNumbers[index5] * 5));

            uglyNumbers[nextUglyIndex] = nextUgly;

            while (uglyNumbers[index2] * 2 <= nextUgly) {
                index2++;
            }
            while (uglyNumbers[index3] * 3 <= nextUgly) {
                index3++;
            }
            while (uglyNumbers[index5] * 5 <= nextUgly) {
                index5++;
            }

            nextUglyIndex++;
        }

        return uglyNumbers[nextUglyIndex - 1];
    }

}
