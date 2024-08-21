package T34在排序数组中查找元素的第一个和最后一个位置;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {1};
        int[] res = so.searchRange(nums, 1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public int[] searchRange(int[] nums, int target) {

        int index = binarySearch(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int start = index, end = index;

        while (start >= 0 && nums[start] == target) {
            start--;
        }
        while (end < nums.length && nums[end] == target) {
            end++;
        }
        return new int[]{start + 1, end - 1};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
