package xian.bishi.meituan01.T2;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] nums = new int[n];
        long currentSum = 0;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            nums[i] = num;
            currentSum += num;
            if (num == 0) {
                zeroCount++;
            }

        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < q; i++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long min = currentSum + zeroCount * l;
            long max = currentSum + zeroCount * r;
            result.append(min).append(" ").append(max).append("\n");

        }
        System.out.println(result);

        in.close();
    }
}
