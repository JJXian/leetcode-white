package com.xian.Z4搜索算法.JZ44数字序列中某一位的数字;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int n = 1010;
        int num = findNthDigit(n);
        System.out.println("the num is :" + num);
    }
    public static int findNthDigit (int n) {
//        n和位置对应关系 看n位对应的数字是多少
        int digitLength = 1; // 当前位数长度
        long count = 9; // 当前位数范围的数字总个数
        long start = 1; // 当前位数范围的起始数字


        while(n > digitLength * count){
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start*= 10;
        }

        // 找到目标数字
        long num = start + (n - 1) / digitLength;
        String numStr = Long.toString(num);

        // 找到目标数字的对应位数
        int digitIndex = (n - 1) % digitLength;
        return Character.getNumericValue(numStr.charAt(digitIndex));
    }
}
