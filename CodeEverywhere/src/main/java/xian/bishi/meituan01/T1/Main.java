package xian.bishi.meituan01.T1;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int num = Integer.parseInt(str);
            for (int j = n - 1; j >= 0; j--) {
                int x = num % 10;
                num = num / 10;
                nums[i][j] = x;
            }
        }

        for (int i = 1; i <= n; i++) {
            int res = countBalance(nums, i);
            System.out.println(res);
        }

    }

    public static int countBalance(int[][] nums, int n) {

        int count = 0;
        for (int i = 0; i <= nums.length - n; i++) {
            for (int j = 0; j <= nums.length - n; j++) {
                if (isBalance(nums, i, j, n)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isBalance(int[][] nums, int row, int col, int n) {
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (nums[i][j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }
        return oneCount == zeroCount;
    }
}










