package T56合并区间;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-16
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入有几组数：");
        int num = sc.nextInt();
        int[][] intervals = new int[num][2];
        for(int i = 0;i<num;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            intervals[i][0] = x;
            intervals[i][1] = y;
        }
        int[][] res = merge(intervals);
        for(int[] x : res){
            System.out.println(x[0]+","+x[1]);
        }


    }

    public static int[][] merge(int[][] intervials){
        if(intervials.length < 2){
            return intervials;
        }
        List<int[]> res = new LinkedList<>();

        int start = intervials[0][0];
        int end = intervials[0][1];
        for(int i = 1;i<intervials.length;i++){
            if(intervials[i][0] <end){
                end = Math.max(end,intervials[i][1]);
            }else{
                res.add(new int[]{start,end});
                start = intervials[i][0];
                end = intervials[i][1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }
}










