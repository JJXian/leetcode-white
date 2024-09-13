package xian;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class calCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(19 * 14);
        while (true) {
            System.out.println("input the shouyilv：");
            double shouyilv = sc.nextDouble();
            if (shouyilv == -1) {
                break;
            }
            System.out.println("input the price：");
            double curPrice = sc.nextDouble();
            double res = curPrice / (1 + shouyilv);
            System.out.println(res);
        }


    }
}
