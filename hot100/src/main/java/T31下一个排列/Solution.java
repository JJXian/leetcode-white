package T31下一个排列;

/**
 * @Author: jjxian
 */
class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {1, 2, 4, 3};
        so.nextPermutation(nums);
        for (int x : nums) {
            System.out.println(x);
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
//        从右往左找到第一个大的元素
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
//        找不到 则就是最大的数 直接逆转
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

// Step 2: 找到比 nums[index] 大的最小元素，并交换
        for (int i = n - 1; i >= index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index + 1, n - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
