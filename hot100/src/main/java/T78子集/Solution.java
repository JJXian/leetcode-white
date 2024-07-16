package T78子集;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution {

    public static void main(String[] args){
        Solution so  = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("input the len of nums:");
        int len = sc.nextInt();
        System.out.println("input the nums:");
        int[] nums = new int[len];
        for(int i = 0 ;i<len ;i++){
            int x = sc.nextInt();
            nums[i] = x;
        }
        List<List<Integer>> ans = so.children(nums);
        System.out.println("the ans is: ");
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
//    结果集和路径集
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> children(int[] nums){
        backTrack(nums,0);
        return res;
    }

//    回溯数组
    public void backTrack(int[] nums, int index){
//        路径加入结果集
        res.add(new ArrayList<>(path));

//        从index遍历之后的数字
        for(int i =index;i<nums.length;i++ ){
//            加入到路径中
            path.add(nums[i]);
            backTrack(nums,++index);
            path.remove(path.size()-1);
        }
    }




}
