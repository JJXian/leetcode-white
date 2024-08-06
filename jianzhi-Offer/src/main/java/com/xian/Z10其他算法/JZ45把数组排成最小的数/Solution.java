package com.xian.Z10其他算法.JZ45把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] numbers = {3, 32, 321}; // 示例输入
        String result = so.PrintMinNumber(numbers);
        System.out.println(result);
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        // 将数字数组转换为字符串数组
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        /**
         * •	使用 Arrays.sort 方法对字符串数组进行排序。
         * 	•	自定义比较器的规则是将两个字符串拼接成两个不同的顺序，
         * 	然后比较这两个拼接结果的大小。如果 s1 + s2 小于 s2 + s1，则 s1 应该排在 s2 的前面。
         */
        // 使用自定义的比较器进行排序
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order1.compareTo(order2);
            }
        });

        // 将排序后的字符串数组拼接成一个字符串
        StringBuilder sb = new StringBuilder();
        for (String str : strNumbers) {
            sb.append(str);
        }

        return sb.toString();
    }


}
