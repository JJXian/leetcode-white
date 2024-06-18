package T287寻找重复数;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-18
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input the length of nums:");
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<nums.length;i++){
            int x = sc.nextInt();
            nums[i]= x;
        }
        int res = findDuplicate(nums);
        for( int y : nums){
            System.out.println(y);
        }
        System.out.println("the nums is : " + res);
    }
    public static int findDuplicate(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }

        Arrays.sort(nums);
        for(int i = 1;i<nums.length ;i++){
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}
