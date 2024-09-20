package com.xian.Z6回溯.JZ13机器人的运动范围;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int threshold = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int res = canArrive(row, col, threshold);
        System.out.println(res);
    }

    public static int canArrive(int row, int col, int threshold) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = countSum(i, j);
                if (sum <= threshold) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countSum(int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum;
    }
}
