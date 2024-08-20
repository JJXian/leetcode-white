package GreedyAlgorithm.T860柠檬水找零;

import java.util.Scanner;

class Solution {
    public static boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount == 0) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else { // 给20元的钱
                if (tenCount != 0 && fiveCount != 0) {
                    tenCount--;
                    fiveCount--;
                } else {
                    if (fiveCount < 3) {
                        return false;
                    } else {
                        fiveCount -= 3;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入顾客数量");
        int n = scanner.nextInt();
        int[] bills = new int[n];
        System.out.println("输入每个顾客给的钱");
        for (int i = 0; i < n; i++) {
            bills[i] = scanner.nextInt();
        }
        boolean result = lemonadeChange(bills);
        System.out.println("能否找零: " + result);
    }
}
