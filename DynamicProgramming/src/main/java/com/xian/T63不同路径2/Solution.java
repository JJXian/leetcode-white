package com.xian.T63不同路径2;

import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-21
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入几行几列row,col : ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] obstacleGrid =new int[row][col];
        System.out.println("输入值：");
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                int x = sc.nextInt();
                obstacleGrid[i][j] = x;
            }
        }

        int res = uniquePathsWithObstacles(obstacleGrid);
        System.out.println("结果是： "+res);
    }

    public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row<2 && col < 2){
            if(obstacleGrid[0][0] == 1){
                return 0;
            }else{
                return 1;
            }

        }
        int[][] dp = new int[row][col];

        for(int i =1;i<row;i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;
            }else{
                dp[i][0] = 1;
            }

        }
        for(int i = 1;i<col ;i++){
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }else{
                dp[0][i] = 1;
            }

        }

        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
