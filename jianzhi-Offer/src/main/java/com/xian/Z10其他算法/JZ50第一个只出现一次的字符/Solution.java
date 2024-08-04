package com.xian.Z10其他算法.JZ50第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        String str = "google";

        int res = so.FirstNotRepeatingChar(str);
        System.out.println(res);
    }

    public int FirstNotRepeatingChar(String str) {
//         使用map统计出现次数 再次遍历找到只出现一次的字符
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
