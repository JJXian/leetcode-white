package xian.bishi.bs360.T1骑行;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] card = new int[4];
        for (int i = 0; i < 4; i++) {
            card[i] = sc.nextInt();
        }
        int[] ride = new int[n];
        for (int i = 0; i < n; i++) {
            ride[i] = sc.nextInt();
        }
        int res = minCost(ride, card);
        System.out.println(res);

    }

    public static int minCost(int[] ride, int[] card) {
        int n = ride.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
//            这次骑行 骑多少次 付多少
            int noCardCost = ride[i - 1];
//            不买卡
            dp[i] = dp[i - 1] + noCardCost;

//            买卡
//            日卡
            dp[i] = Math.min(dp[i - 1] + card[0], dp[i]);
//            月卡
            if (i > 30) {
                dp[i] = Math.min(dp[i], dp[i - 30] + card[1]);
            } else {
                dp[i] = Math.min(dp[i], dp[0] + card[1]);
            }
//            年卡
            if (i > 365) {
                dp[i] = Math.min(dp[i], dp[i - 365] + card[2]);
            } else {
                dp[i] = Math.min(dp[i], dp[0] + card[2]);
            }
//            十年卡
            if (i > 3850) {
                dp[i] = Math.min(dp[i], dp[i - 3650] + card[3]);
            } else {
                dp[i] = Math.min(dp[i], dp[0] + card[3]);
            }
        }
        return dp[n];


    }
}
