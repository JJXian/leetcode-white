package GreedyAlgorithm.T738.单调递增的数字;

import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-17
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数：");
        int n = sc.nextInt();
        int res = monotoneIncreasingDigits(n);
        System.out.println("结果是：" + res);

    }

    public static int monotoneIncreasingDigits(int n) {
        String[] s = (n + "").split("");

        int start = s.length;
        for (int i = s.length - 1; i > 0; i--) {
            if (Integer.parseInt(s[i]) < Integer.parseInt(s[i - 1])) {
                s[i - 1] = Integer.parseInt(s[i - 1]) - 1 + "";
                start = i;
            }
        }
        for (int i = start; i < s.length; i++) {
            s[i] = "9";
        }
        return Integer.parseInt(String.join("", s));
    }
}
