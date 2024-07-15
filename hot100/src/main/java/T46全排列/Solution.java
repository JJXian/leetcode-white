package T46全排列;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    private List<List<Integer>> permute(int[] nums){
        backTrack(nums,new boolean[nums.length] );
        return res;
    }

    private void backTrack(int[] nums,boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }

        for(int i = 0;i<nums.length;i++){
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("input the length of nums:");
        int length = sc.nextInt();
        int[] nums = new int[length];
        System.out.println("input the nums:");
        for(int i = 0;i<length;i++){
            int x= sc.nextInt();
            nums[i] = x;
        }
        Solution so = new Solution();
        List<List<Integer>> ans = so.permute(nums);
        System.out.println("结果是：");
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
}
