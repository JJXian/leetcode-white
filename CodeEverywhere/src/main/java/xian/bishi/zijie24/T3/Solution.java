package xian.bishi.zijie24.T3;


import java.util.Objects;
import java.util.Scanner;

/**
 * 使用前缀和优化 不用每次累加求和
 *
 * @Author: jjxian
 */
public class Solution {
    static int LeftStart = 0;
    static int RightStart = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 彩带长度
        int q = sc.nextInt();  // 剪彩次数
        int[] nums = new int[n];
        int[] prefixSum = new int[n + 1];

        // 计算前缀和数组
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        RightStart = n - 1;

        for (int i = 0; i < q; i++) {
            String ch = sc.next();
            int x = sc.nextInt();
            int res = sumValue(nums, prefixSum, ch, x);
            System.out.println(res);
        }
    }

    public static int sumValue(int[] nums, int[] prefixSum, String c, int x) {
        int n = nums.length;
        int sum = 0;
        if (x > n) {
            int times = x / nums.length;
            sum += prefixSum[n] * times;
            x = x % n;
        }

        // 从左往右剪
        if (Objects.equals(c, "L")) {
            int end = (LeftStart + x) % n;
            if (end > LeftStart) {
                sum += prefixSum[end] - prefixSum[LeftStart];
            } else {
                sum += prefixSum[n] - prefixSum[LeftStart] + prefixSum[end];
            }
            LeftStart = end;
        } else { // 从右往左剪
            int end = (RightStart - x + n) % n;
            if (RightStart >= end) {
                sum += prefixSum[RightStart + 1] - prefixSum[end + 1];
            } else {
                sum += prefixSum[RightStart + 1] + (prefixSum[n] - prefixSum[end + 1]);
            }
            RightStart = end;
        }

        return sum;
    }
}
