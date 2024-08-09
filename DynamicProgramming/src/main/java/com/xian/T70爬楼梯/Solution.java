package com.xian.T70爬楼梯;

import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-18
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input the n:");
        int n = sc.nextInt();
        int res = climbStairs(n);
        System.out.println("res:" + res);
    }
    public static int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
