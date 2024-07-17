package T22括号生成;

/**
 * @Author: jjxian
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            res.add(current.toString());
            return;
        }
        // 左括号小于最大
        if (open < max) {
            current.append('(');
            backtrack(res, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        // 右括号数量小于左括号 添加右括号
        if (close < open) {
            current.append(')');
            backtrack(res, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
