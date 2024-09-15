package com.xian.Z4搜索算法.JZ38字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: jjxian
 */
public class Solution2 {
    static ArrayList<String> res = new ArrayList<>();
    static StringBuilder path = new StringBuilder();
    static boolean[] used;

    public static void main(String[] args) {
        String s = "a";
//        ArrayList<String> res = findPaiLie(s);
        used = new boolean[s.length()];
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        backTrace(temp, 0);

        System.out.println(res);
    }


    public static void backTrace(char[] chars, int index) {
        if (path.length() == chars.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue; // 跳过已使用的字符‼️
            // 避免重复: 当前字符和前一个字符相同时，且前一个字符使用过，跳过‼️
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            path.append(chars[i]);
            used[i] = true; // 标记字符已使用
            backTrace(chars, index + 1);
            used[i] = false; // 回溯，解除字符使用标记
            path.deleteCharAt(path.length() - 1); // 回溯，删除最后一个字符
        }
    }
}








