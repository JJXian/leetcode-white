package T239滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-21
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input the size of nums:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0 ;i<n;i++){
            int x = sc.nextInt();
            nums[i] = x;
        }
        System.out.println("input the target:");
        int target = sc.nextInt();
        int[] res = maxSlidingWindow(nums,target);
        System.out.println("结果是：");
        for(int i = 0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        // 初始化第一个窗口的双端队列
        for (int i = 0; i < k; i++) {
            // 维护递减的双端队列，确保队首元素始终是当前窗口的最大值的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // 处理第一个窗口的最大值
        res[0] = nums[deque.peekFirst()];

        // 滑动窗口，计算每个窗口的最大值
        for (int i = k; i < n; i++) {
            // 移除不在窗口范围内的元素
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 维护递减的双端队列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 记录当前窗口的最大值
            res[i - k + 1] = nums[deque.peekFirst()];
        }

        return res;
    }
}
