package com.xian.Z10其他算法.JZ14剪绳子;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        int x = so.cutRope(8);
        System.out.println(x);

    }

    public int cutRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * 2.	外层 Math.max(dp[i], ...)：
                 * 	•	这个部分是为了保证在不同的 j 值下，dp[i] 保持最大的值，因为 j 可以取 1 到 i-1 的值，
                 * 	我们需要找到使乘积最大的那一个。
                 * 	3.	内层 Math.max(j * (i - j), j * dp[i - j])：
                 * 	•	j * (i - j)：表示将绳子剪成两段，一段长度为 j，另一段长度为 i - j，这时的乘积。
                 * 	•	j * dp[i - j]：表示将绳子剪成两段，一段长度为 j，另一段长度为 i - j，
                 * 	并且 i - j 段继续剪成若干段后的最大乘积。这个乘积的意思是，我们可以继续剪短长度为 i - j 的绳子，而不是简单地把它当作一个整体。
                 */
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
