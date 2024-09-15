package xian.bishi.tclx0913.T1小牛的魔法数字;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 输入字符串长度
        int k = sc.nextInt(); // 输入窗口大小
        String s = sc.next(); // 输入字符串

        char[] nums = s.toCharArray();
        int res = findMinTimes(nums, k);
        System.out.println(res);
    }

    public static int findMinTimes(char[] nums, int k) {
        int minTimes = Integer.MAX_VALUE;

        // 遍历所有的窗口
        for (int i = 0; i <= nums.length - k; i++) {
            char[] window = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(window);
            int count = countTimes(window);
            minTimes = Math.min(minTimes, count);
        }

        return minTimes;
    }

    // 计算窗口中最小的调整次数
    public static int countTimes(char[] nums) {
        int count = 0;
        int mid = nums.length / 2;
        // 找到中位数后，计算其他数字到中位数的距离
        for (char num : nums) {
            count += Math.abs(num - nums[mid]);
        }
        return count;
    }
}
