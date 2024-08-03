package com.xian.Z8位运算.JZ65不用加减乘除做加法;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int x = so.Add(3, 3);
        System.out.println(x);
    }

    /**
     * 1.	int carry = a & b; 这一步计算 a 和 b 中哪些位需要进位。只有当 a 和 b 中对应的位都是1时，才会有进位。
     * 2.	a = a ^ b; 这一步计算无进位加法。异或操作符 ^ 可以将 a 和 b 中不相同的位保留，相同的位清零，得到无进位的和。
     * 3.	b = carry << 1; 这一步将 carry 左移一位，相当于将进位值加到更高的位上。
     * 4.	while (b != 0) 循环直到没有进位为止，即 b 变为0，此时 a 中包含了最终的和。
     *
     * @param a
     * @param b
     * @return
     */
    public int Add(int a, int b) {
        while (b != 0) {
            // 计算进位
            int carry = a & b;
            // 进行无进位加法
            a = a ^ b;
            // 将进位左移一位
            b = carry << 1;
        }
        return a;
    }
}
