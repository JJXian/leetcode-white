package com.xian.Z5动态规划.JZ47礼物的最大价值;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = new int[][]{{9,1,4,8}};
        int value = maxValue(grid);
        System.out.println("the res is :" + value);
    }
    public static int maxValue (int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
//        初始化dp
        dp[0][0] = grid[0][0];
//        第一列累加前一项
        for(int i =1 ;i<row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
//      第一行累加起来
        for(int j = 1;j<col;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
//      其他行 列赋值
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
