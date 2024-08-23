package xian.bishi.shenxinfu0818.T1;

import java.util.Scanner;

/**
 * LYA 是一家魔法糖果工厂的新任管理员。工厂生产的魔法糖果有七种颜色，分别用字母 a、b、c、d、e、f、g 表示。这些糖果被排列在一条传送带上，准备进行包装。
 * <p>
 * 为了提高效率，工厂引进了一台智能包装机器人。这个机器人可以按照预设的指令序列来包装糖果。指令序列由字符 a、b、c、d、e、f、g 和 * 组成。其中，a 到 g 表示机器人可以包装对应颜色的糖果，而 * 则表示机器人可以重复前一个动作任意次（包括 0 次）。
 * <p>
 * 如果指令序列执行完毕，或者遇到当前无法匹配的糖果，机器人就会停止工作。LYA 想知道，按照给定的指令序列，机器人最多能包装多少个糖果。
 * <p>
 * 输入格式
 * 第一行输入一个字符串，表示传送带上
 * 𝑁
 * N 个糖果的颜色序列，长度
 * 𝑁
 * N 不超过 1000。
 * <p>
 * 第二行输入一个字符串，表示机器人的指令序列
 * 𝑆
 * S，
 * 𝑆
 * S 的长度不超过 1000。
 * <p>
 * 输出格式
 * 输出一个整数，表示机器人最多可以包装的糖果数量。
 *
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String order = sc.next();
        int res = countNum(s, order);
//        int res = countPackagedCandies(s, order);
        System.out.println(res);
    }

    public static int countNum(String s, String order) {
        int count = 0;
        int index = 0;
        char lastCh = ' ';
        for (int i = 0; i < s.length() && index < order.length(); i++) {
            char ch = s.charAt(i);
            char currentOrder = order.charAt(index);
//            如果当前指令为*  只要当前字符是否等于前一个字符
            if (currentOrder == '*') {
                while (s.charAt(i) == lastCh && i < s.length()) {
                    count++;
                    i++;
                }
                i--;
            } else {
//                如果不是* 判断是否和前一个相同 相同总数++ 否则终止
                if (ch == currentOrder) {
                    count++;
                } else {
                    return count;
                }
            }
            index++;
            lastCh = ch;
        }
        return count;
    }

    public static int countPackagedCandies(String candies, String instructions) {
        char last = '*';
        int idx = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == '*') {
                if (last == '*') continue;
                while (idx < candies.length() && candies.charAt(idx) == last) {
                    idx++;
                }
            } else {
                if (idx >= candies.length() || candies.charAt(idx) != ch) break;
                idx++;
            }
            last = ch;
        }
        return idx;
    }
}
