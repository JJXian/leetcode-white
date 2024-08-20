package xian.bishi.zijie24.T3;

import java.util.Objects;
import java.util.Scanner;

/**
 * * 6 3
 * * 1 1 4 5 1 4
 * * L 2
 * * L 3
 * * R 12
 *
 * @Author: jjxian
 */
public class Main {
    static int LeftStart = 0;
    static int RightStart = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        彩带长度
        int n = sc.nextInt();
        // 剪彩次数
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        RightStart = nums.length - 1;

        for (int i = 0; i < q; i++) {
            String ch = sc.next();
            int x = sc.nextInt();
            int res = sumValue(nums, ch, x);
            System.out.println(res);
        }

    }

    public static int sumValue(int[] nums, String c, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        if (x > nums.length) {
            int times = x / nums.length;
            sum += total * times;
            x = x % nums.length;
        }
//        从左往右
        if (Objects.equals(c, "L")) {
            int index = LeftStart;
            while (x > 0) {
                sum += nums[index++];
                index = index % nums.length;
                x--;
            }
            LeftStart = index;
        } else {// 从右往左
            int index = RightStart;
            while (x > 0) {
                sum += nums[index--];
                index = index % nums.length;
                if (index < 0) {
                    index = nums.length + index;
                }
                x--;
            }
            RightStart = index;
        }

        return sum;
    }
}
