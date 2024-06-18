package T746最小花费爬楼梯;

import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-18
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input the num of stage:");
        int n = sc.nextInt();
        System.out.println("输入每个楼梯的花费：");
        int[] cost = new int[n];
        for(int i = 0;i<n;i++){
            cost[i] = sc.nextInt();
        }
        int res = minCostClimbingStairs(cost);
        System.out.println("最小花费："+res);
    }


    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=cost.length;i++){
            // dp[i] =Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
            if(dp[i-2]+cost[i-2] < dp[i-1]+cost[i-1]){
                dp[i] = dp[i-2] + cost[i-2];

            }else{
                dp[i] = dp[i-1] + cost[i-1];
            }

        }
        return dp[cost.length];
    }
}
