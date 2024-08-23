package xian.bishi.shenxinfu0818.T3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * K小姐是一位热爱旅行的摄影师。她计划进行一次精彩的摄影之旅，并希望从众多景点中选择最佳组合。为了做出明智的选择，她对每个景点进行了详细评估，考虑了以下因素：
 * 体力消耗（mmm）：拍摄和探索景点所需的体力。
 * 灵感值（nnn）：景点能激发的创作灵感。
 * 位置（x,yx, yx,y）：景点的地理坐标，以K小姐的家（0,00, 00,0）为原点。
 * 从一个景点到另一个景点的体力消耗计算方式为：∣x1−x2∣+∣y1−y2∣|x1-x2|+|y1-y2|∣x1−x2∣+∣y1−y2∣。
 * K小姐想从ttt个景点中选择kkk个进行拍摄。她的旅程将从家出发，依次游览这kkk个景点，最后返回家。旅程的舒适度定义为：总灵感值（cncncn）除以总体力消耗（cmcmcm）。
 * cmcmcm：所有景点的体力消耗之和，加上旅途中的体力消耗。
 * cncncn：所有景点的灵感值之和。
 * 请帮助K小姐规划出舒适度最高的旅行路线。
 * 输入格式
 * 第一行输入两个整数 ttt 和 kkk，用空格分隔，分别表示景点总数和计划游览的景点数量。保证 0<k≤t0 < k \leq t0<k≤t。
 * 接下来的 ttt 行，每行包含四个数值 mmm、nnn、xxx 和 yyy，用空格分隔。其中 mmm 和 nnn 为整数，(x,y)(x, y)(x,y) 为景点坐标。
 * 输出格式
 * 输出一个小数，表示最优旅行路线的舒适度，保留6位小数。
 * <p>
 * ]
 * <p>
 * 样例输入
 * 3 2
 * 6 20 10 15
 * -5 10 30 27
 * -15 10 20 25
 * 样例输出
 * 0.370370
 *
 * @Author: jjxian
 */
public class Main {
    static int t, k;
    static int[][] spots;
    static double maxComfort = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        景点总数t
        t = sc.nextInt();
//        计划游览的景点总数k
        k = sc.nextInt();
//        行：多少个景点
        spots = new int[t][4];
//        int[][] grid = new int[t][4];
//        体力消耗m 灵感获得n 坐标x y
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            spots[i][0] = m;
            spots[i][1] = n;
            spots[i][2] = x;
            spots[i][3] = y;
        }

        List<Integer> chosenSpots = new ArrayList<>();
        backtrack(0, chosenSpots);

        System.out.printf("%.6f\n", maxComfort);
    }


    // 回溯法
    private static void backtrack(int index, List<Integer> chosenSpots) {
        if (chosenSpots.size() == k) {
            calculateComfort(chosenSpots);
            return;
        }

//        if (index >= t) {
//            return;
//        }
        // 遍历剩余的景点
        for (int i = index; i < t; i++) {
            chosenSpots.add(i);
            backtrack(i + 1, chosenSpots);
            chosenSpots.remove(chosenSpots.size() - 1); // 回溯
        }
//
//        chosenSpots.add(index);
//        backtrack(index + 1, chosenSpots);
//        chosenSpots.remove(chosenSpots.size() - 1);
//        backtrack(index + 1, chosenSpots);
    }

    // 计算当前组合的舒适度
    private static void calculateComfort(List<Integer> chosenSpots) {
        int totalInspiration = 0;
        int totalEnergy = 0;
//         记录上一景点的坐标
        int prevX = 0, prevY = 0;

        for (int i : chosenSpots) {
            totalInspiration += spots[i][1];
//            景点消耗的体力 + 路途消耗的体力
            totalEnergy += spots[i][0];
            totalEnergy += Math.abs(spots[i][2] - prevX) + Math.abs(spots[i][3] - prevY);

            prevX = spots[i][2];
            prevY = spots[i][3];
        }

        // 返回家
        totalEnergy += Math.abs(prevX) + Math.abs(prevY);
//      计算舒适度
        double comfort = (double) totalInspiration / totalEnergy;
//        记录最大舒适度
        maxComfort = Math.max(maxComfort, comfort);
    }
}







