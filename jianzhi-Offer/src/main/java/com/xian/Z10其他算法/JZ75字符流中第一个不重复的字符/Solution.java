package com.xian.Z10其他算法.JZ75字符流中第一个不重复的字符;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jjxian
 */
public class Solution {
    //Insert one char from stringstream
    StringBuilder sb = new StringBuilder();

    public void Insert(char ch) {
        sb.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}
