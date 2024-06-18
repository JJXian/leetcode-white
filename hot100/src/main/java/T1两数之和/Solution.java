package T1两数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-17
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("请输入几个数字");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            int x= sc.nextInt();
            nums[i] =x;
        }
        System.out.println("请输入target：");
        int target = sc.nextInt();
        int[]  res = new int[2];
        res = twoSum(nums,target);
        System.out.println(res[0]+","+res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i<nums.length;i++){
            int x = target - nums[i];
            // 先把map构建出来 容易造成一个数字用两次。要判断i!= map.get(x)
            if(map.containsKey(x) && map.get(x) != i){
                return new int[]{i,map.get(x)};
            }
        }
        return new int[0];
    }
}
