package com.xian.Z3队列or栈.JZ59滑动窗口的最大值;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: jjxian
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        List<Integer> result = maxInWindows2(num, size);
        System.out.println(result);  // 输出: [4, 4, 6, 6, 6, 5]
    }


    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList list = new ArrayList<>();
        if (num == null || size <= 0 || num.length < size) {
            return list;
        }
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
//           移除不在窗口内的元素
            if (!queue.isEmpty() && queue.peekFirst() < i - size + 1) {
                queue.pollFirst();
            }
//           保持从大到小
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= size - 1) {
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }

    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0 || num.length < size) {
            return res;
        }
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
//            窗口大于size 移除不属于窗口的元素
            if (!queue.isEmpty() && queue.peekFirst() < i - size + 1) {
                queue.pollFirst();
            }
//                保持窗口内从大到小排序
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);

//                如果窗口元素size个以上 ，开始输出结果
            if (i >= size - 1) {
                res.add(num[queue.peekFirst()]);
            }

        }
        return res;

    }


}
