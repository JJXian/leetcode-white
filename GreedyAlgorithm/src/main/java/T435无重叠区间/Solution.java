package T435无重叠区间;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-16
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入个数：");
        int num = sc.nextInt();
        int[][] intervals = new int[num][2];
        for(int i = 0;i<num;i++){
            int x= sc.nextInt();
            int y = sc.nextInt();
            intervals[i][0] = x;
            intervals[i][1] = y;
        }
        int x = eraseOverlapIntervals(intervals);
        System.out.println("最少需要："+ x);
        for(int i=0;i<num;i++){
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals.length==1){
            return 0;
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
//        Arrays.sort(intervals, (a, b) -> {
//            if (a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            } else {
//                return Integer.compare(a[1], b[1]);
//            }
//        });

        for(int i=0;i<intervals.length;i++){
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }

        int count = 0;
        int end = intervals[0][1];
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] < end){
                count++;
            }else{
                end = intervals[i][1];
            }
        }
        return count;
    }
}
