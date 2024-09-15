package com.xian.Z4搜索算法.JZ44数字序列中某一位的数字;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        int n = 13;
        int num = findNum(n);
        System.out.println(num);
    }

    public static int findNum(int n) {
        if (n == 0) {
            return 0;
        }
        int digitLen = 1;
        int count = 9;
        int start = 1;

        while (n > digitLen * count) {
            n -= digitLen * count;
            digitLen++;
            count *= 10;
            start *= 10;
        }

        // 找到目标数字
        long num = start + (n - 1) / digitLen;
        String numStr = Long.toString(num);

        // 找到目标数字的对应位数
        int digitIndex = (n - 1) % digitLen;
        return Character.getNumericValue(numStr.charAt(digitIndex));
    }
}
