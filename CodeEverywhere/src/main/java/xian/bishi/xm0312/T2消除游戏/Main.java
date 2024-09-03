package xian.bishi.xm0312.T2消除游戏;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = a;
        if (n > 1) {
            dp[1] = Math.max(dp[0] + a, (s[0] == s[1] ? b : 2 * a));
        }
        if (n > 2) {
            dp[2] = Math.max(Math.max(dp[1] + a, dp[0] + (s[1] == s[2] ? b : 2 * a)),
                    s[0] == s[1] && s[1] == s[2] ? c : 3 * a);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + a; // 单消
            if (s[i] == s[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 2] + b); // 二消
            }
            if (s[i] == s[i - 1] && s[i - 1] == s[i - 2]) {
                dp[i] = Math.max(dp[i], dp[i - 3] + c); // 三消
            }
        }

        System.out.println(dp[n - 1]);
    }
}
