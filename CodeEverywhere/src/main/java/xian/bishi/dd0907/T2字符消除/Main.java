package xian.bishi.dd0907.T2字符消除;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] cost = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        String s = sc.next();

        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
//        保存好下标
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(str[i])) {
                map.put(str[i], index++);
            }
        }

        int res = findMax(n, cost, s);
        System.out.println(res);

    }


    public static int findMax(int n, int[][] cost, String s) {

        int maxCost = 0;
//
//
//        for (int i = 0; i < str.length - 1; i++) {
//            int tempMax = 0;
//            for (int j = i + 1; j < str.length; j += 2) {
//                int ch1 = map.get(str[i]);
//                int ch2 = map.get(str[j]);
//                int tempCost = cost[ch1][ch2];
//                tempMax = Math.max(tempCost, tempMax);
//            }
//            maxCost += tempMax;
//
//        }


//        for(int i = 1;i<n;i++){
//            int ch1 = map.get(str[i]);
//            int ch2 = map.get(str[i-1]);
//
//        }

//        dp表示前2*i个字符中 能花掉的最多钱 1 3 5 7 。。。
//        int[] dp = new int[n];
//        dp[1] = cost[map.get(str[0])][map.get(str[1])];
//        if (n < 2) {
//            return dp[1];
//        }
//        for (int i = 3; i < n; i += 2) {
//
//        }


        return maxCost;

    }
}
