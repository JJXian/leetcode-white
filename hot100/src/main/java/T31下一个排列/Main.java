package T31下一个排列;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = {1, 2, 3};
        m.nextPermutation(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n - 2;

        // 1. 找到第一个逆序对的位置 i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 2. 找到第一个比 nums[i] 大的数的位置 j
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 3. 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 4. 反转 i 之后的所有元素
        reverse(nums, i + 1);

    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void reverse(int[] nums, int index) {
        int left = index, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
