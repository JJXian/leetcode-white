package com.xian.Z5动态规划.JZ48最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int x = lengthOfLongestSubstring(s);
        System.out.println(x);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        char[] schar = s.toCharArray();
        for (int i = 0; i < schar.length; i++) {
            char ch = schar[i];
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - start + 1);
        }
        return max;


    }
}
