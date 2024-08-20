package xian.bishi.zijie23.T3好数组;

import java.util.Arrays;
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
            int num = sc.nextInt();
            nums[i] = num;
        }
        Solution so = new Solution();
        long res = so.minOprea(nums);
        System.out.println(res);
    }

    public long minOprea(int[] nums) {
//      找到好元素 距离最远的元素不用变  累加其他的变化次数
        Map<Integer, Integer> map = new HashMap<>();
        int haoEle = nums[0];
        int max = 1;
//        找到好元素
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (max < map.get(nums[i])) {
                    max = map.get(nums[i]);
                    haoEle = nums[i];
                }
            }
        }
        Arrays.sort(nums);
        if (nums[0] == haoEle && nums[nums.length - 1] == haoEle) {
            return 1;
        }
        long count = 0;
        int flag = -1;
        if (nums[0] - haoEle > nums[nums.length - 1] - haoEle) {
            flag = 0;
        } else {
            flag = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag == 0 && i == 0) {
                continue;
            }
            if (flag == 1 && i == nums.length - 1) {
                continue;
            }
            count += Math.abs(nums[i] - haoEle);
        }
        return count;


    }
}
