package xian.bishi.zijie24.T1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = countSpecialSubarrays(nums);
        System.out.println(res);
    }

    public static int countSpecialSubarrays(int[] nums) {
        int count = 0;

        // 遍历所有可能的子数组长度，最小为3
        for (int length = 3; length <= nums.length; length++) {
            Map<Integer, Integer> map = new HashMap<>();
            // 初始化滑动窗口
            for (int i = 0; i < length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            if (isSpecial(map)) {
                count++;
            }

            // 滑动窗口
            for (int start = 1; start <= nums.length - length; start++) {
                // 移除旧的
                int oldVal = nums[start - 1];
                map.put(oldVal, map.get(oldVal) - 1);
                if (map.get(oldVal) == 0) {
                    map.remove(oldVal);
                }

                // 添加新的
                int newVal = nums[start + length - 1];
                map.put(newVal, map.getOrDefault(newVal, 0) + 1);


                if (isSpecial(map)) {
                    count++;
                }
            }
        }

        return count;
    }

    // 判断当前的map是否是特殊数组
    private static boolean isSpecial(Map<Integer, Integer> map) {
        if (map.size() != 2) {
            return false;
        }
        int countOne = 0;
        for (int freq : map.values()) {
            if (freq == 1) {
                countOne++;
            } else if (freq > 1 && countOne > 1) {
                return false;
            }
        }
        return countOne == 1;
    }
}
