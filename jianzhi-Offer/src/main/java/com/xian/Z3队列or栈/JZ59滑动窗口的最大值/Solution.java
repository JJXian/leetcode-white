package com.xian.Z3队列or栈.JZ59滑动窗口的最大值;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        List<Integer> result = maxInWindows(num, size);
        System.out.println(result);  // 输出: [4, 4, 6, 6, 6, 5]
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || size <= 0 || num.length < size) {
            return result;
        }
        Deque<Integer> deque = new LinkedList<>();


        for (int i = 0; i < num.length; i++) {
//            移除不在当前窗口范围内的元素
            if (!deque.isEmpty() && deque.peekFirst() < i - size + 1) {
                deque.pollFirst();
            }
//            保持队列的元素是从大到小
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }
//            添加当前元素的下标到队列中
            deque.offerLast(i);
//            从size-1的个元素记录窗口最大值
            if (i >= size - 1) {
                result.add(num[deque.peekFirst()]);
            }
        }
        return result;
//
//        for (int i = 0; i < num.length; i++) {
//            // 移除不在当前窗口内的元素
//            if (!deque.isEmpty() && deque.peekFirst() < i - size + 1) {
//                deque.pollFirst();
//            }
//            // 保持双端队列内的元素为从大到小顺序
//            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
//                deque.pollLast();
//            }
//            // 添加当前元素的下标到双端队列
//            deque.offerLast(i);
//            // 从第size-1个元素开始记录窗口最大值
//            if (i >= size - 1) {
//                result.add(num[deque.peekFirst()]);
//            }
//        }
//        return result;
    }

}
