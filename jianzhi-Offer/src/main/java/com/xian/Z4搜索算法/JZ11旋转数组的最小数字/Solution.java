package com.xian.Z4搜索算法.JZ11旋转数组的最小数字;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 2};
        System.out.println("The minimum value is: " + minNumberInRotateArray(arr));
    }

    public static int minNumberInRotateArray (int[] nums) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(left == right){
                return nums[left];
            }
//          mid>right时候， 最小值在右边
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            }else{//处理有重复元素的数组
                right--;
            }

        }
        return nums[left];
    }
}
