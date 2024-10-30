package xian.bishi.hsdz0926.T2;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    static long[] preSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        preSum = new long[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        long res = findRes(nums, k);
        System.out.println(res);
    }


    public static long findRes(long[] nums, int k) {
        long max = 0;
        for (int left = 0; left < nums.length - 1; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                if (preSum[right] - preSum[left] + nums[left] <= k) {
                    max = Math.max(max, count(nums, left, right));
                }
            }
        }
        return max == 0 ? -1 : max;

    }

    /**
     * 计算S
     */
    public static long count(long[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        long res = 0;
        for (int i = l; i < r; i++) {
            res += gcd(nums[i], nums[i + 1]);
        }
        return res;
    }

    /**
     * 计算最大公因数
     *
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        if (a < b) {
            long t = a;
            a = b;
            b = t;
        }
        while (b != 0) {
            long k = a % b;
            a = b;
            b = k;
        }
        return a;
    }
}
