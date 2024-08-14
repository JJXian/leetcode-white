package com.xian.T392判断子序列;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        boolean res = so.isSubsequence("abc", "ahbgdc");
        System.out.println(res);
    }

    public boolean isSubsequence(String s, String t) {
        // 最长公共子序列长度为 s.length();
        int m = s.length();
        int n = t.length();
        int len = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[m][n]);
        if (dp[m][n] == m) {
            return true;
        } else {
            return false;
        }

    }
}
