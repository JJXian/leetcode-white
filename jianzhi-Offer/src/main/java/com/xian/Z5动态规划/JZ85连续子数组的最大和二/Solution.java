package com.xian.Z5动态规划.JZ85连续子数组的最大和二;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
//        int[] array = {1,2,-3,4,-1,1,-3,2};
        int[] res = FindGreatestSumOfSubArray(array);
        for(int num : res){
            System.out.println(num);
        }
    }

    public static int[] FindGreatestSumOfSubArray(int[] array){
        //记录到下标i为止的最大连续子数组和
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxsum = dp[0];
        //滑动区间
        int left = 0, right = 0;
        //记录最长的区间
        int resl = 0, resr = 0;
        for(int i = 1; i < array.length; i++){
            right++;
            //状态转移：连续子数组和最大值
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            //区间新起点
            if(dp[i - 1] + array[i] < array[i])
                left = right;
            //更新最大值
            if(dp[i] > maxsum || dp[i] == maxsum && (right - left + 1) > (resr - resl + 1)){
                maxsum = dp[i];
                resl = left;
                resr = right;
            }
        }
        //取数组
        int[] res = new int[resr - resl + 1];
        for(int i = resl; i <= resr; i++)
            res[i - resl] = array[i];
        return res;
    }

//    public static int[] FindGreatestSumOfSubArray (int[] array) {
////        dp 第i个为止连续子数组的最大和
//        int n = array.length;
//        int currentSum = array[0];
//
//        int startIndex=0, endIndex=0,tempStart = 0;
//        int max = array[0];
//
//        for(int i = 1;i<n;i++){
//            if(currentSum + array[i] > array[i]){
//                currentSum = currentSum + array[i];
//            }else{
//                currentSum = array[i];
//                tempStart = i;
//            }
//            if(currentSum > max){
//                startIndex = tempStart;
//                max = currentSum;
//                endIndex =i;
//            }else if(currentSum == max){ //        最大和相等取子数组最长的
//                if(i - tempStart > endIndex - startIndex ||  (i - tempStart == endIndex - startIndex && tempStart < startIndex)){
//                    startIndex = tempStart;
//                    endIndex = i;
//                }
//            }
//        }
//
//        int[] res = new int[endIndex - startIndex + 1];
//        int index = 0;
//        for(int i = startIndex; i<=endIndex;i++){
//            res[index++] = array[i];
//        }
//        return res;
//
//
//    }

}
