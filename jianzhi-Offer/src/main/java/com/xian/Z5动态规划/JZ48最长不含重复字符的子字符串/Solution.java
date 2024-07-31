package com.xian.Z5动态规划.JZ48最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        String s = "dvdf";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] schar = s.toCharArray();
        int max = 0;
        int start = 0;// 标记起始字符开始位置
        for (int i = 0; i < schar.length; i++) {
//            检查当前字符是否已经存在于 map 中（即是否之前出现过）。
            if (map.containsKey(schar[i])) {
                //如果当前字符已经出现过，就更新 start 位置。
                // 这里使用 Math.max 是为了确保 start 不会倒退。
                // map.get(schar[i]) + 1 表示前一个相同字符之后的一个位置，因为从这个位置开始，不会再有重复字符。
                start = Math.max(start, map.get(schar[i]) + 1);
            }
//            更新 map 中当前字符的位置为 i，即字符最后出现的位置。
            map.put(schar[i], i);
//            计算当前无重复子串的长度 i - start + 1，并更新 max 为更大的值
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
