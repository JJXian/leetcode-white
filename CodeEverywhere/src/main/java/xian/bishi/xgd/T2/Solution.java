package xian.bishi.xgd.T2;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    private static final double ERROR = 1e-6;

    /**
     * 24点游戏
     * 对于任意给定的一个4个值的数组，如果通过加减乘除可以得到24，则返回true，要求每个数都要用到。
     * <p>
     * 要求：每个数m满足 0<m<10且是整数。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }

        boolean res = point24(nums);
    }

    /**
     * 初始化24点，并计算24点是否可以被计算出来
     *
     * @param nums
     */
    public static boolean point24(int[] nums) {

        boolean res = false;
        int num = 1;
        for (int i = 0; i < 4; i++) {
            num = nums[i] * num;
        }

        //此处进行判定
        return num == 24;
    }
}

