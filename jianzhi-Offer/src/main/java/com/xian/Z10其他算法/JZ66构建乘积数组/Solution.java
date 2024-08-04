package com.xian.Z10其他算法.JZ66构建乘积数组;

/**
 * 1.	构建前缀积数组：遍历数组 A，计算每个位置 i 之前所有元素的乘积，存储在 prefix 数组中。
 * 2.	构建后缀积数组：逆向遍历数组 A，计算每个位置 i 之后所有元素的乘积，存储在 suffix 数组中。
 * 3.	构建结果数组 B：B[i] 等于 prefix[i] 和 suffix[i] 的乘积。
 *
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] res = so.multiply(A);
        for (int num : res) {
            System.out.println(num);
        }
    }

    /**
     * 优化实现
     *
     * @param A
     * @return
     */
    public int[] multiply2(int[] A) {
        int n = A.length;
        int[] B = new int[n];

        if (n == 0) {
            return B;
        }

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // 前缀积
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * A[i - 1];
        }

        // 后缀积
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * A[i + 1];
        }

        // 结果数组
        for (int i = 0; i < n; i++) {
            B[i] = prefix[i] * suffix[i];
        }

        return B;
    }

    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        int[] prex = new int[len];
//        计算前缀乘积数组
        for (int i = 0; i < len; i++) {
            prex[i] = 1;
            for (int j = 0; j < i; j++) {
                prex[i] *= A[j];
            }
        }
        int[] post = new int[len];
//        计算后缀乘积数组
        for (int i = 0; i < len; i++) {
            post[i] = 1;
            for (int j = i + 1; j < len; j++) {
                post[i] *= A[j];
            }
        }
//      遍历相乘
        for (int i = 0; i < len; i++) {
            B[i] = prex[i] * post[i];
        }


        return B;
    }
}
