package xian.bishi.dd0907.T1对比之美;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n + 1];
            int res = findBeautiful(nums, m);
            System.out.print(res + " ");
        }

    }


    public static int findBeautiful(int[] nums, int m) {
        int n = nums.length;
        if (n - 1 == 1) {
            return 0;
        }
        nums[2] = m;
        int beautyNum = 0;
        for (int i = 2; i < n; i++) {
            beautyNum += Math.abs(nums[i] - nums[i - 1]);
        }


        return beautyNum;
    }
}
