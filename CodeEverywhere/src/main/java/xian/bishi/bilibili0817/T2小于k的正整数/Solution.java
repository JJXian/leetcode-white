package xian.bishi.bilibili0817.T2小于k的正整数;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();
//        int res = countPlan(num, k);
        int res = count(num, k);
        System.out.println(res);

    }


    public static int count(String num, int k) {
        int count = 0;
        int currentNum = 0;
        int left = 0;
        for (int right = 0; right < num.length(); right++) {
            currentNum = currentNum * 10 + (num.charAt(right) - '0');
            while (currentNum >= k && left <= right) {
                currentNum -= (num.charAt(left) - '0') * Math.pow(10, right - left);
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public static int countPlan(String num, int k) {
        int count = 0;
        long currentNum = 0;
        int left = 0;

        for (int right = 0; right < num.length(); right++) {
            // 扩展窗口，加入当前数字
            currentNum = currentNum * 10 + (num.charAt(right) - '0');

            // 如果当前数字大于等于k，移动左指针缩小窗口
            while (currentNum >= k && left <= right) {
                currentNum -= (num.charAt(left) - '0') * Math.pow(10, right - left);
                left++;
            }

            // 窗口内的所有子串都符合条件，更新计数
            count += (right - left + 1);
        }

        return count;
    }
}
