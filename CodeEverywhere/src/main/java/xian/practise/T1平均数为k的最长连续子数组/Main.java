package xian.practise.T1平均数为k的最长连续子数组;

/**
 * @Author: jjxian
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int longestSubarrayWithAverageK(int[] nums, int k) {
        // 创建一个哈希表，用来存储 (prefixSum - index * k) 和 对应的索引值
        Map<Long, Integer> map = new HashMap<>();
        long prefixSum = 0;  // 当前的前缀和
        int maxLength = 0;  // 记录最长子数组的长度

        // 初始化，处理 prefixSum 本身为0的情况
        map.put(0L, -1);

        // 更新前缀和
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // 计算当前的目标值
            long target = prefixSum - (long) (i + 1) * k;

            // 如果哈希表中已经存在这个目标值，计算当前最长子数组的长度
            if (map.containsKey(target)) {
                int previousIndex = map.get(target);
                maxLength = Math.max(maxLength, i - previousIndex);
            }

            // 如果哈希表中不存在这个目标值，将当前索引保存
            if (!map.containsKey(target)) {
                map.put(target, i);
            }
        }
        // 返回最长子数组的长度
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2};
        int k = 2;
        int result = longestSubarrayWithAverageK(nums, k);
        int res = findLen(nums, k);
        // 输出应该是 3，因为 [2, 3, 4] 的平均值为 3
        System.out.println("最长子数组的长度为: " + result);
        System.out.println(res);

    }

    public static int findLen(int[] nums, int k) {
        int prefixSum = 0;
        int maxLen = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            long target = prefixSum - (long) (i + 1) * k;
            if (map.containsKey(target)) {
                int preIndex = map.get(target);
                maxLen = Math.max(maxLen, i - preIndex);
            }

            if (!map.containsKey(target)) {
                map.put(target, i);
            }


        }
        return maxLen;
    }
}
