package com.xian.Z9模拟.JZ29顺时针打印矩阵;

import java.util.ArrayList;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        ArrayList<Integer> res = so.printMatrix(matrix);
        for (int x : res) {
            System.out.println(x);
        }
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>();


        while (true) {
//            从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down) {
                break;
            }
//            从上到下
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
//            从右到左
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }

//            从下到上
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
