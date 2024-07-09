package T438找到字符串中所有的异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = findAnagrams(s,p);
        System.out.println(res);
    }



    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        Arrays.sort(pchar);
        for(int i = 0;i<s.length()-n+1;i++){
            int index = i;
            char[] temp = new char[n];
            for(int j = 0;j<n-1;j++){
                temp[j] = schar[index++];
            }
            Arrays.sort(temp);
            if(Arrays.equals(temp,pchar)){
                res.add(i);
            }
        }
        return res;
    }

}
