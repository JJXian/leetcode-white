package com.xian.Z7排序.JZ41数据流中的中位数;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        so.Insert(1);
        so.Insert(2);
        System.out.println(so.GetMedian()); // 1.5
        so.Insert(3);
        System.out.println(so.GetMedian()); // 2.0
    }

    ArrayList<Integer> nums = new ArrayList<>();

    public void Insert(Integer num) {
        nums.add(num);

    }

    public Double GetMedian() {
        Collections.sort(nums);
        int len = nums.size();
        if (len % 2 == 1) {
            return (double) nums.get(len / 2);
        } else {
            return (nums.get(len / 2 - 1) + nums.get(len / 2)) / 2.0;
        }
    }


}
