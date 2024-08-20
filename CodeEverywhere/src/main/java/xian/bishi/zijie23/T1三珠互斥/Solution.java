package xian.bishi.zijie23.T1三珠互斥;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution so = new Solution();
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long a1 = sc.nextInt();
            long a2 = sc.nextInt();
            long a3 = sc.nextInt();
            long res = so.minSwapTimes(n, k, a1, a2, a3);
            System.out.println(res);
        }
    }

    public long minSwapTimes(int n, int k, long a1, long a2, long a3) {
        if (k * 3 > n) {
            return -1;
        }
        long[] nums = new long[]{a1, a2, a3};
        Arrays.sort(nums);

        //第二个和第一个的距离不足k时要补的数 + 同理第三和第二的 + 同理第一和第三的
//        因为是环形的 所以第三个是第三个到第一个的距离
        /**
         * •	Math.max(0L, k - (nums[1] - nums[0])): 计算第二个红色珠子和第一个红色珠子之间的距离是否足够。如果不足 k，则需要进行调整，计算所需的补充距离。
         * 	•	Math.max(0L, k - (nums[2] - nums[1])): 计算第三个红色珠子和第二个红色珠子之间的距离是否足够。如果不足 k，则需要进行调整，计算所需的补充距离。
         * 	•	Math.max(0L, k - (n - nums[2] + nums[0])): 计算考虑到环状排列时，第三个红色珠子到第一个红色珠子之间的距离是否足够。如果不足 k，则需要进行调整，计算所需的补充距离。
         * 将这些需要补充的距离相加，得到总的最小交换次数。
         */
        long res = Math.max(0L, k - (nums[1] - nums[0]))
                + Math.max(0L, k - (nums[2] - nums[1]))
                + Math.max(0L, k - (n - nums[2] + nums[0]));

        return res;

    }
}
