package com.xian.Z4搜索算法.JZ53数字在升序数组中出现的次数;

/**
 * @Author: jjxian
 */
public class Solution {
    public int GetNumberOfK (int[] nums, int k) {
//        1、找到元素
        int index = binarySearch(nums,k);
        if(index == -1){
            return 0;
        }

//        2、中心扩散 向左右找
        int left = index,right = index;
        while(left>=0 && nums[left] == k){
            left--;
        }
        while(right <= nums.length-1 && nums[right] == k){
            right++;
        }
        int count = right - left - 1;

//        3、计算长度
        return count;
    }

    public int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right - left) /2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }
}
