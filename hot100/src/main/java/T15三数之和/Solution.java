package T15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution so = new Solution();
        List<List<Integer>> res = so.threeSum(nums);
        for (List<Integer> l : res) {
            System.out.println(l);
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -nums[i] - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == target) {
                        res.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }
        return res;
    }
}
