package T416分割等和子集;

import java.util.Arrays;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-22
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println("结果："+ canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0;i<nums.length;i++){
            int sum1 = 0,sum2 = 0;
            for(int k = 0;k<=i;k++){
                sum1+=nums[k];
            }
            for(int j = nums.length-1;j>i;j--){
                sum2+=nums[j];
            }
            if(sum1 == sum2){
                return true;
            }

        }
        return false;

    }
}
