package xian.bishi.meituan01.T2;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int min = countMax(nums, l);
            int max = countMin(nums, r);
            System.out.println(min + " " + max);
        }

//
//        while (in.hasNextInt()) {
//            int n = in.nextInt();
//            int q = in.nextInt();
//            int[] nums = new int[n];
//            long knownSum = 0;
//            int zeroCount = 0;
//
//            for (int i = 0; i < n; i++) {
//                nums[i] = in.nextInt();
//                if (nums[i] == 0) {
//                    zeroCount++;
//                } else {
//                    knownSum += nums[i];
//                }
//            }
//
//            StringBuilder result = new StringBuilder();
//            for (int queryNums = 0; queryNums < q; queryNums++) {
//                long left = in.nextLong();
//                long right = in.nextLong();
//
//                long minSum = knownSum + zeroCount * left;
//                long maxSum = knownSum + zeroCount * right;
//
//                result.append(minSum).append(" ").append(maxSum).append("\n");
//            }
//
//            System.out.print(result);
//        }
        in.close();
    }

    public static int countMax(int[] nums, int left) {
        int zeroCount = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (n == 0) {
                zeroCount++;
            }
        }
        return sum + zeroCount * left;
    }

    public static int countMin(int[] nums, int right) {
        int zeroCount = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (n == 0) {
                zeroCount++;
            }
        }
        return sum + zeroCount * right;
    }


}
