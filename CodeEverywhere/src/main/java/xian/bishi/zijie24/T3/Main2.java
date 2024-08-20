package xian.bishi.zijie24.T3;

import java.util.Objects;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main2 {
    static int LeftStart = 0;
    static int RightStart = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 彩带长度
        int q = sc.nextInt();  // 剪彩次数
        int[] nums = new int[n];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            total += nums[i];
        }

        RightStart = nums.length - 1;

        for (int i = 0; i < q; i++) {
            String ch = sc.next();
            int x = sc.nextInt();
            int res = sumValue(nums, ch, x, total);
            System.out.println(res);
        }
    }

    public static int sumValue(int[] nums, String c, int x, int total) {
        int n = nums.length;
        int sum = 0;

        // 如果 x 大于数组长度，先计算整段的总和
        if (x >= n) {
            sum += (x / n) * total;
            x = x % n;
        }

        // 根据指令选择从左到右还是从右到左
        if (Objects.equals(c, "L")) {
            for (int i = 0; i < x; i++) {
                sum += nums[LeftStart];
                LeftStart = (LeftStart + 1) % n;
            }
        } else { // 从右往左
            for (int i = 0; i < x; i++) {
                sum += nums[RightStart];
                RightStart = (RightStart - 1 + n) % n;
            }
        }

        return sum;
    }
}
