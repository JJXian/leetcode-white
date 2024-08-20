package xian.bishi.zijie24.T1;

import java.util.*;

/**
 * 4
 * 2 2 3 2
 * 结果： 3
 * 题目是给你一个数组，要求判断该数组的大于等于3的子数组中，
 * 有多少个是特殊数组，所谓特殊数组就是其中只包含两个数字，一个数字的个数为1，其余的为另外一个数字
 *
 * @Author: jjxian
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = isSpecialArray(nums);
        System.out.println(res);

    }

    public static int isSpecialArray(int[] nums) {
        int count = 0;
// TODO 找子串的最优方式
        for (int i = 3; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length - i; j++) {
                int[] subArray = Arrays.copyOfRange(nums, j, j + i);
                if (helper(subArray)) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 判断是不是特殊数组
     */
    public static boolean helper(int[] array) {
        Arrays.sort(array);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (!map.containsKey(num)) {
                if (map.size() == 2) {
                    return false;
                }
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Set<Integer> set = map.keySet();
        boolean flag = false;
        for (Integer key : set) {
            if (map.get(key) == 1) {
                flag = true;
            }
        }
        return flag;
    }
}
