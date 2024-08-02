package com.xian.Z7排序.JZ40最小的K个数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入数组长度:");
//        int length = sc.nextInt();
//        int[] input = new int[length];
//        System.out.println("输入数组元素，空格隔开：");
//        for (int i = 0; i < length; i++) {
//            int num = sc.nextInt();
//            input[i] = num;
//        }
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = so.GetLeastNumbers_Solution(input, 4);
        System.out.println(res);
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return res;  // 处理边界情况
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < input.length; i++) {
//            if (queue.size() < k) {
//                queue.add(input[i]);
//            } else if (input[i] < queue.peek()) {
//                queue.poll();
//                queue.add(input[i]);
//            }
            queue.add(input[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            res.add(x);
        }
        return res;
    }
}
