package com.xian.T647回文子串;


/**
 * @Author: jjxian
 */
class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        String s = "abc";
        int res = so.countSubstrings(s);
        System.out.println(res);
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isHuiWen(str)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isHuiWen(String s) {
        if (s.length() == 0) {
            return false;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
