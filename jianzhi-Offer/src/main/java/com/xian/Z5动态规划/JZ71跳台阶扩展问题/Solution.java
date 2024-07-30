package com.xian.Z5动态规划.JZ71跳台阶扩展问题;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int number = 3;
        int res = jumpFloorII(number);
        System.out.println(res);
    }
    public static int jumpFloorII (int number) {
//        dp 到第i个台阶能跳的最大
        int[] dp = new int[number+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i<=number;i++){
            //        从每一个台阶跳上来
            for(int j = 0;j<i;j++){
                dp[i] += dp[j];
            }
        }
        return dp[number];


    }
}
