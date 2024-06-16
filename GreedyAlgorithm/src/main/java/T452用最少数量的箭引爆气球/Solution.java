package T452用最少数量的箭引爆气球;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-16
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入气球数：");
        int num = sc.nextInt();
        int[][] points = new int[num][2];
        for(int i = 0;i<num;i++){
            int x= sc.nextInt();
            int y = sc.nextInt();
            points[i][0] = x;
            points[i][1] = y;
        }
        int x = findMinArrowShots(points);
        System.out.println("最少需要："+ x);
        for(int i=0;i<num;i++){
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        // 按照气球的结束位置 xend 进行升序排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1; // 初始化箭的数量为1，因为第一支箭一定会射出去
        int end = points[0][1]; // 记录当前箭的射出位置，初始为第一个气球的结束位置

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // 当前气球的开始位置大于当前箭的射出位置，需要额外一支箭
                arrows++;
                end = points[i][1]; // 更新箭的射出位置为当前气球的结束位置
            }
            // 如果当前气球的开始位置在当前箭的射出位置之内，则可以一箭引爆该气球，无需额外处理
        }

        return arrows;
    }

}
