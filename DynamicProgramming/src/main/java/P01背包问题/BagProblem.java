package P01背包问题;

import java.util.Scanner;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-22
 */
public class BagProblem {

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入物品数量，和背包大小：");
//        int M = sc.nextInt();
//        int N = sc.nextInt();
//        int[] space = new int[M];
//        int[] value = new int[M];
//        System.out.println("输入物品占用空间");
//
//        for(int i = 0;i<M;i++){
//            space[i] = sc.nextInt();
//        }
//        System.out.println("输入物品价值");
//        for(int i = 0;i<N;i++){
//            value[i] = sc.nextInt();
//        }
//
//        int res= findMax(space,value,N);
//        System.out.println(res);

        int[] weight = {2 ,2, 3, 1, 5, 2};
        int[] value = {2 ,3 ,1 ,5 ,4 ,3};
        int bagSize = 1;
        int res = findMax(weight,value,bagSize);
        System.out.println("结果是：" + res);
//        testWeightBagProblem(weight,value,bagSize);

    }

    public static int findMax(int[] space, int[] value,int bagsize){


        int[][] dp = new int[space.length][bagsize+1];

        // 初始化
        for(int i = 0;i<space.length;i++){
            dp[i][0] = 0;
        }

        for(int i = 1;i<=bagsize;i++){
            if(space[0] <= bagsize){
                dp[0][i] = value[0];
            }else{
                dp[0][i] = 0;
            }
        }

        for(int i = 1 ;i<space.length;i++){
            for(int j=1;j<=bagsize;j++){
                if(j<space[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i-1][j-space[i]]+value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }

        return dp[space.length-1][bagsize];
    }


    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i-1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
