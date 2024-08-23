package xian.bishi.shenxinfu0818.T2;

import java.util.Scanner;

/**
 * 问题描述
 * LYA 是一位著名的魔法珠宝设计师，她正在筹备一场盛大的魔法珠宝展览会。展览会上有
 * 𝑛
 * n 件珠宝作品，每件作品都有一个独特的魔法能量值。为了让展览更有趣，LYA 决定从这些作品中挑选一些进行特别展示。
 * <p>
 * 然而，魔法珠宝之间会相互影响，所以 LYA 必须遵守一个特殊规则：相邻展示的两件珠宝在原始排列中的位置间隔不能小于
 * 𝑘
 * k。LYA 希望挑选出的珠宝的魔法能量值之和最大，同时保持它们在原始排列中的相对顺序不变。
 * <p>
 * 输入格式
 * 第一行包含两个整数
 * 𝑛
 * n 和
 * 𝑘
 * k，分别表示珠宝的总数和最小位置间隔。
 * <p>
 * 第二行包含
 * 𝑛
 * n 个整数，表示每件珠宝的魔法能量值。
 * <p>
 * 输出格式
 * 输出一个整数，表示满足条件的最大魔法能量值之和。
 *
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = countSum(nums, k);
        System.out.println(res);

    }

    public static int countSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
//        初始化
        for (int i = 0; i < k; i++) {
            dp[i] = nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = k; i < nums.length; i++) {
            for (int j = i - k; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
