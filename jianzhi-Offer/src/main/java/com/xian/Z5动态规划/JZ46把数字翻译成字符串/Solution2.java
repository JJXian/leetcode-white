package com.xian.Z5动态规划.JZ46把数字翻译成字符串;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        String s = "31717126241541717";
        int res = fingWay(s);
        System.out.println(res);
    }

    public static int fingWay(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }
        
        char[] schar = s.toCharArray();
        int[] dp = new int[schar.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= schar.length; i++) {
            int preNum = schar[i - 2] - '0';
            int curNum = schar[i - 1] - '0';
            int num = preNum * 10 + curNum;
            // 如果当前字符可以单独翻译
//            if (curNum >= 1 && curNum <= 9) {
//                dp[i] = dp[i - 1];
//            }
            dp[i] = dp[i - 1];
            // 如果前两位可以作为一个合法的翻译
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[schar.length];

    }
}
