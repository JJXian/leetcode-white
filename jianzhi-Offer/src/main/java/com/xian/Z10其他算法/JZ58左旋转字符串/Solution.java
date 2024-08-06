package com.xian.Z10其他算法.JZ58左旋转字符串;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        String res = so.LeftRotateString("aab", 10);
        System.out.println(res);
    }

    public String LeftRotateString(String str, int n) {
        if (str == "" || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        int time = n % str.length();
        int index = chars.length - time;
        char[] cur = new char[time];
        for (int i = 0; i < time; i++) {
            cur[i] = chars[i];
        }
        for (int i = 0; i < chars.length - time; i++) {
            chars[i] = chars[i + time];
        }
        int j = 0;
        for (int i = index; i < chars.length; i++) {
            chars[i] = cur[j++];
        }

        return new String(chars);

    }
}
