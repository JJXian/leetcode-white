package xian.bishi.zijie24.T2;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eventNum = sc.nextInt();
        int baoUp = sc.nextInt();
        // 0 : x 1 :y  2:z
        int[][] value = new int[eventNum][3];
        for (int i = 0; i < eventNum; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            value[i][0] = x;
            value[i][1] = y;
            value[i][2] = z;
        }


    }

    public static int maxMoney(int[][] value, int baoUp) {

        int baoNum = 0;
        int money = 0;
        int[] baoshi = new int[value.length + 1];
        int[] jinbi = new int[value.length + 1];
        baoshi[0] = 0;
        jinbi[0] = 0;
//        事件数量
        for (int i = 1; i <= value.length; i++) {
//            事件下标
            int index = i - 1;
//            如果宝石为空 只能选择2 获取宝石
            if (baoshi[i - 1] == 0) {
                baoshi[i] = value[index][2];
            } else {
//            宝石不为空 比较选择1和选择2
//                计算目前为止选择1的最大金币
                baoshi[i] = baoshi[i - 1] - value[index][0];
                jinbi[i] = jinbi[i - 1] + value[index][1];

//                选择2
                baoshi[i] = Math.max(baoUp, baoshi[i - 1] + value[index][2]);
                jinbi[i] = jinbi[i - 1];

/**
 *         jinbi = max(选择1， xuanze2)
 */


            }


//            如果宝石>m 选择 1
        }
        return 1;

    }
}
