package com.xian.Z5动态规划.JZ69跳台阶;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int  number = 1;
        int res = jumpFloor(number);
        System.out.println(res);
    }
    public static int jumpFloor (int number) {
//        到第i次跳台阶的总不同
        int[] dp = new int[number+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i =2; i <= number;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[number];

    }
}
