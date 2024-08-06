package com.xian.Z10其他算法.JZ62孩子们的游戏_圆圈中最后剩下的数;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int n = 10; // 总的小朋友数量
        int m = 3;  // 报数的数值
        System.out.println("最后一个小朋友的编号是：" + so.LastRemaining_Solution(n, m));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int currentIndex = 0;
        while (list.size() > 1) {
            currentIndex = (currentIndex + m - 1) % list.size();
            list.remove(currentIndex);
        }
        return list.get(0);
    }
}
