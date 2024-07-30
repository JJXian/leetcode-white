package com.xian.Z5动态规划.JZ10斐波那契数列;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int res = Fibonacci(n);
        System.out.println(res);

    }
    public static int Fibonacci (int n) {
        if(n <= 2){
            return 1;
        }

        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
