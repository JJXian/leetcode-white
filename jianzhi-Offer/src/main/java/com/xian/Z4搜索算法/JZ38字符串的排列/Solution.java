package com.xian.Z4搜索算法.JZ38字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static ArrayList<String> res = new ArrayList<>();
    static StringBuilder path = new StringBuilder();
    static boolean[] used;

    public static ArrayList<String> Permutation(String str) {
        res.clear(); // 清空结果列表
        if (str == null || str.length() == 0) {
            return res;
        }
        used = new boolean[str.length()];
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // 对字符数组进行排序‼️
        backTrace(chars, 0);
        return res;
    }

    public static void backTrace(char[] chars, int index) {
        if (path.length() == chars.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue; // 跳过已使用的字符‼️
            // 避免重复: 当前字符和前一个字符相同时，且前一个字符未使用，跳过‼️
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            path.append(chars[i]);
            used[i] = true; // 标记字符已使用
            backTrace(chars, index + 1);
            used[i] = false; // 回溯，解除字符使用标记
            path.deleteCharAt(path.length() - 1); // 回溯，删除最后一个字符
        }
    }

    public static void main(String[] args) {
//        测试用例 aa ab aba
        String str = "aba";
        ArrayList<String> permutations = Permutation(str);
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}