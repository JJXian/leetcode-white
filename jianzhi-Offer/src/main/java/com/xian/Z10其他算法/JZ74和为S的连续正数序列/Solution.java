package com.xian.Z10其他算法.JZ74和为S的连续正数序列;

import java.util.ArrayList;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        ArrayList<ArrayList<Integer>> res = so.FindContinuousSequence(100);
        for (ArrayList<Integer> cur : res) {
            System.out.println(cur);
        }
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 1; i < sum; i++) {
            int count = 0;
            ArrayList<Integer> current = new ArrayList<>();
            for (int j = i; j < sum; j++) {
                current.add(j);
                count += j;
                if (count == sum) {
                    res.add(current);
                    break;
                }
            }
        }
        return res;

    }
}
