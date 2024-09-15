package com.xian.Z3队列or栈.JZ73翻转单词序列;

import java.util.Scanner;

/**
 * @Author: jjxian
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = ReverseSentence(s);
        System.out.println(res);
    }

    public static String ReverseSentence(String str) {
        if (str.length() == 0) {
            return str;
        }
        
        String[] temp = str.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = temp.length - 1; i >= 0; i--) {
            res.append(temp[i]);
            if (i != 0) {
                res.append(" ");
            }
        }

        return res.toString();


    }
}
