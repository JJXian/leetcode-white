package xian.bishi.mihayou.test1;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // 注意 while 处理多个 case
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int res = swapAndMax(nums);
        System.out.println(res);
    }

    public static int swapAndMax(int[] nums) {
        if (nums.length <= 2) {
            return nums[0] * nums[1];
        }
        int max = Integer.MIN_VALUE;
        // 遍历相邻中乘积最大
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] * nums[i + 1] > max) {
                max = nums[i] * nums[i + 1];
            }
        }
        // 遍历间隔一个数乘积最大
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] * nums[i + 2] > max) {
                max = nums[i] * nums[i + 2];
            }
        }
//      没有考虑最后两个元素的乘积
////        遍历相邻中乘积最大
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] * nums[i + 1] > max) {
//                max = nums[i] * nums[i + 1];
//            }
//            if (nums[i] * nums[i + 2] > max) {
//                max = nums[i] * nums[i + 2];
//            }
//        }
        return max;

//        Arrays.sort(nums);
//        int len = nums.length - 1;
//        if (nums[0] * nums[1] > nums[len] * nums[len - 1]) {
//            return nums[0] * nums[1];
//        } else {
//            return nums[len] * nums[len - 1];
//        }

    }


}