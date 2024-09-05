package bishi.xm0905.T2xuliexiugai;

import java.util.Scanner;

/**
 * 给一个长度为n的序列和整数x，每次操作可以选择从序列中删除或者加1，
 * 至少操作多少次，才能让和为x的倍数
 *
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = minStep(nums, x);
        System.out.println(res);

    }


//    public static int minStep(int[] nums, int x) {
//        int n = nums.length;
//        int[][] dp = new int[nums.length][2];
////        删除状态
//        dp[0][0] = 1;
////        加1状态
//        dp[0][1] = -1;
//
//        for (int i = 1; i < n; i++) {
//            int sum = 0;
//            for (int j = 0; j <= i; j++) {
//                sum += nums[j];
//            }
//            if (isBei(sum, x)) {
//                dp[i]
//            }
//        }
//        return 1;
//
//    }


    public static boolean isBei(int num, int x) {
        if (num == 0) {
            return true;
        }
        int index = 1;
        while (num % x != 0 && num > x) {
            x *= index;
            index++;
        }
        return num % x == 0;
    }

    public static int minStep(int[] nums, int x) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        return (sum - x) % x;
    }

}
