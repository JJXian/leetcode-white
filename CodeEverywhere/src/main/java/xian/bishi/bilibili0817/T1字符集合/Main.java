package xian.bishi.bilibili0817.T1字符集合;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        String s = "BAabB";
//        String res = concatStr(s);
        String res = concatString(s);
        System.out.println(res);

    }

    public static String concatString(String s) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                continue;
            } else {
                sb.append(ch);
                set.add(ch);
            }
        }
        return sb.toString();
    }

    public static String concatStr(String s) {
        Map<Integer, Character> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsValue(ch)) {
                continue;
            } else {
                map.put(index, ch);
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            sb.append(map.get(i));
        }
        return sb.toString();


    }
}
