package com.xian.Z10其他算法.JZ5替换空格;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        String s = "we are failly";
        String res = so.replaceSpace(s);
        System.out.println(res);
    }


    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
