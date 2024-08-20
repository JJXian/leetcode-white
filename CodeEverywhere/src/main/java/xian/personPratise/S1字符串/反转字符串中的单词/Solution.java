package xian.personPratise.S1字符串.反转字符串中的单词;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        String s = " the sky is blue ";
        String res = so.reverseWords(s);
        System.out.println(res);
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");


        StringBuilder sb = new StringBuilder();
        int index = str.length - 1;
        for (int i = 0; i < str.length; i++) {
            sb.append(str[index--]);
            if (i != str.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }
}
