package com.xian.Z9模拟.JZ61扑克牌顺子;

import java.util.Arrays;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] numbers = new int[]{0, 0, 3, 6, 6};
        boolean res = so.IsContinuous(numbers);
        System.out.println(res);
    }

    public boolean IsContinuous(int[] numbers) {
        Arrays.sort(numbers);
        int countZero = 0;
        int gaps = 0;
        for (int num : numbers) {
            if (num == 0) {
                countZero++;
            }
        }

        for (int i = countZero; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            gaps += numbers[i + 1] - numbers[i] - 1;
        }
        return gaps <= countZero;
    }
}
