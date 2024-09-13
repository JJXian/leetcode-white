package xian.bishi.zwjt0906;

import java.util.Arrays;


public class Solution {

    public static void main(String[] args) {
        String[] paths = {"x->y->z", "x->y", "x->y->a->b"};
        String res = LongestBehaviorPath(paths);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回路径字符串
     *
     * @param paths string字符串一维数组
     * @return string字符串
     */
    public static String LongestBehaviorPath(String[] paths) {
        Arrays.sort(paths);
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (String s : paths) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i += 3) {
                char ch = chars[i];
                if (i == 0) {
                    while (temp.length() != 0 && temp.charAt(temp.length() - 1) != ch) {
                        temp.deleteCharAt(temp.length() - 1);
                    }
                    if (temp.length() != 0) {
                        temp.deleteCharAt(temp.length() - 1);
                    }
                }
                temp.append(ch);
                if (i != chars.length - 1) {
                    temp.append("->");
                }
            }
            if (temp.length() > res.length()) {
                res = new StringBuilder(temp);
//                res = temp;
            }
        }

        return res.toString();
    }


}