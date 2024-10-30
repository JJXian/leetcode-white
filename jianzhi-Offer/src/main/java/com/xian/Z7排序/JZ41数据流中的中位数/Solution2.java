package com.xian.Z7排序.JZ41数据流中的中位数;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: jjxian
 */
public class Solution2 {
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void Insert(Integer num) {
        nums.add(num);
    }

    public static Double getMid() {
        Collections.sort(nums);
        if (nums.size() % 2 == 1) {
            return (double) nums.get(nums.size() / 2);
        } else {
            return (nums.get(nums.size() / 2 - 1) + nums.get(nums.size() / 2)) / 2.0;
        }
    }
}
