package xian.bishi.tclx0913.T1小牛的魔法数字;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        char[] nums = s.toCharArray();

        int res = findMinTimes(nums, k);
        System.out.println(res);

    }

    public static int findMinTimes(char[] nums, int k) {
        int minTimes = Integer.MAX_VALUE;
        int count;
        for (int i = 0; i < nums.length - k + 1; i++) {
            char[] temp = new char[k];
            int index = 0;
            for (int j = i; j < i + k; j++) {
//                窗口内的k个元素
                temp[index++] = nums[j];
            }
//            计算最小数
            count = countTimes(temp);
            minTimes = Math.min(minTimes, count);
        }
        return minTimes;
    }


    public static int countTimes(char[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if (nums.length == 1) {
            return count;
        }
        int mid;
        if (nums.length % 2 == 1) {
            mid = nums.length / 2;
            for (int i = 0; i < nums.length; i++) {
                if (i < mid) {
                    count += nums[mid] - nums[i];
                } else {
                    count += nums[i] - nums[mid];
                }
            }
        } else {
            mid = nums.length / 2;
            int count1 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i < mid) {
                    count1 += nums[mid] - nums[i];
                } else {
                    count1 += nums[i] - nums[mid];
                }
            }
            mid = nums.length / 2 - 1;
            int count2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i < mid) {
                    count2 += nums[mid] - nums[i];
                } else {
                    count2 += nums[i] - nums[mid];
                }
            }
            count = Math.min(count1, count2);

        }

        return count;
    }
}
