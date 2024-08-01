package com.xian.Z7排序.JZ3数组中重复的数字;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 9, 5, 3, 3};
        int res = solution.duplicate(nums);
        System.out.println(res);
    }

    public int duplicate(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                return numbers[i];
            }
        }
        return -1;
    }

    public void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            int pivot = partition(numbers, left, right);
            quickSort(numbers, left, pivot - 1);
            quickSort(numbers, pivot + 1, right);
        }

    }

    public int partition(int[] numbers, int left, int right) {
        int pivot = numbers[left];
        while (left < right) {
            while (left < right && pivot <= numbers[right]) {
                right--;
            }
            numbers[left] = numbers[right];

            while (left < right && pivot >= numbers[left]) {
                left++;
            }
            numbers[right] = numbers[left];
        }
        numbers[left] = pivot;
        return left;
    }
}
