package bishi.mt0831.T1;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int count = 0;
        for (String str : strs) {
            if (str.length() != 0 && str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
                count++;
            }
        }
        System.out.println(count);
    }
}
