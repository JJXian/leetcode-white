package com.xian.Z6回溯.JZ13机器人的运动范围;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        int threshold = 10;
        int rows = 1;
        int cols = 100;
        int res = so.movingCount(threshold, rows, cols);
        System.out.println(res);

    }

    public int movingCount(int threshold, int rows, int cols) {
        int[][] visited = new int[rows][cols];
        return dfs(0, 0, rows, cols, visited, threshold);
    }

    public int dfs(int x, int y, int rows, int cols, int[][] visited, int threshold) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] == 1 || !canEnter(x, y, threshold)) {
            return 0;
        }
        visited[x][y] = 1;

        return 1 + dfs(x - 1, y, rows, cols, visited, threshold)
                + dfs(x + 1, y, rows, cols, visited, threshold)
                + dfs(x, y - 1, rows, cols, visited, threshold)
                + dfs(x, y + 1, rows, cols, visited, threshold);
    }

    public boolean canEnter(int rows, int cols, int threshold) {
        int sum = digitSum(rows) + digitSum(cols);
        return sum <= threshold;
    }


    public int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
//    public int movingCount(int threshold, int rows, int cols) {
////        深度优先遍历
//        int[][] visited = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                int sum = 0, x = i, y = j;
//                while (x != 0) {
//                    sum += x % 10;
//                    x = x / 10;
//                }
//                while (y != 0) {
//                    sum += y % 10;
//                    y = y / 10;
//                }
//                if (sum > threshold) {
//
//                } else {
//                    visited[i][j] = 1;
//                }
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (visited[i][j] == 1) {
//                    count++;
//                }
//            }
//        }
//        return count;

//    }


}
