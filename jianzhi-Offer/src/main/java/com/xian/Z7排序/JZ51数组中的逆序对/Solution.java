package com.xian.Z7排序.JZ51数组中的逆序对;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        Solution so = new Solution();

        int res = so.InversePairs(nums);
        System.out.println(res);
    }

    private static final int MOD = 1000000007;

    public int InversePairs(int[] nums) {
//        为空或者长度不足2 没有逆序对
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return (int) (mergeSortAndCount(nums, temp, 0, nums.length - 1) % MOD);
    }

    public long mergeSortAndCount(int[] nums, int[] temp, int left, int right) {
//        归并结束
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        long count = 0;
        count += mergeSortAndCount(nums, temp, left, mid);
        count += mergeSortAndCount(nums, temp, mid + 1, right);
        count += mergeAndCount(nums, temp, left, mid, right);
        return count % MOD;
    }

    public long mergeAndCount(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
//                当 array[i] > array[j] 时，产生逆序对，并累加计数。
                temp[k++] = nums[j++];
                count += (mid - i + 1);
                if (count >= MOD) {
                    count %= MOD;
                }
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
        return count;
    }


//
//    public int InversePairs(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return 0;
//        }
//        int[] temp = new int[nums.length];
//        return (int) (mergeSortAndCount(nums, temp, 0, nums.length - 1) % MOD);
//    }

//    private static long mergeSortAndCount(int[] array, int[] temp, int left, int right) {
//        if (left >= right) {
//            return 0;
//        }
//        int mid = left + (right - left) / 2;
//        long count = 0;
//        count += mergeSortAndCount(array, temp, left, mid);
//        count += mergeSortAndCount(array, temp, mid + 1, right);
//        count += mergeAndCount(array, temp, left, mid, right);
//        return count % MOD;
//    }


//
//    private static long mergeAndCount(int[] array, int[] temp, int left, int mid, int right) {
//        int i = left, j = mid + 1, k = left;
//        long count = 0;
//
//        while (i <= mid && j <= right) {
//            if (array[i] <= array[j]) {
//                temp[k++] = array[i++];
//            } else {
////                当 array[i] > array[j] 时，产生逆序对，并累加计数。
//                temp[k++] = array[j++];
//                count += (mid - i + 1);
//                if (count >= MOD) {
//                    count %= MOD;
//                }
//            }
//        }
//
//        while (i <= mid) {
//            temp[k++] = array[i++];
//        }
//
//        while (j <= right) {
//            temp[k++] = array[j++];
//        }
//
//        for (i = left; i <= right; i++) {
//            array[i] = temp[i];
//        }
//
//        return count;
//    }
}
