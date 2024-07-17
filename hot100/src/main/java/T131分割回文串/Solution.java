package T131分割回文串;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: jjxian
 */
class Solution {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return res;
    }

    // 回溯分割子串
    public void backTrack(String s,int index){
        // 子串长度达到len
        if(index >= s.length()){
            res.add(new ArrayList<>(path));
            return ;
        }

        for(int i = index ;i<s.length();i++){

            if(isHuiwen(s,index,i)){
                String str = s.substring(index,i+1);
                path.add(str);
            }else{
                continue;
            }

            //起始位置后移，保证不重复
            backTrack(s,i+1);
            path.remove(path.size() -1 );

        }
    }

    // 判断是否是回文串
    public boolean isHuiwen(String str,int start, int end){
        int len = end - start;
        for(int i = start,j=end;i<=j;i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution so = new Solution();
        System.out.println("input the string:");
        String s = sc.nextLine();
        List<List<String>> res = so.partition(s);
        System.out.println("the result : ");
        for(List<String> list : res){
            System.out.println(list);
        }


    }
}
