package xian.bishi.qne.T3真伪周期串;

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
        String s = sc.next();
        char[] str = s.toCharArray();

        Map<Character, Integer> map;
        int count = 0;
        for (int left = 0; left < n - 1; left++) {
            map = new HashMap<>();
            map.put(str[left], 1);
            int right = left + 1;
            map.put(str[right], map.getOrDefault(str[right], 0) + 1);
            while (right < n - 1 && !isOu(map, left, right, str)) {
                right++;
                map.put(str[right], map.getOrDefault(str[right], 0) + 1);
            }
            if (str.length == 2 && isOu(map, left, right, str)) {
                count++;
                break;
            }
            left = right;
        }
        System.out.println(count);
    }

    public static boolean isOu(Map<Character, Integer> map, int start, int end, char[] str) {
        for (int k = start; k <= end; k++) {
            if (map.get(str[k]) % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
