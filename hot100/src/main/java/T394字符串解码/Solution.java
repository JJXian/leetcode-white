package T394字符串解码;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-26
 */

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(currentNumber);
                stringStack.push(currentString);
                currentNumber = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String encodedString;
        String decodedString;
//        String encodedString = "3[a]2[bc]";
//        String decodedString = solution.decodeString(encodedString);
//        System.out.println(decodedString); // Output: "aaabcbc"

        encodedString = "3[a2[c]]";
        decodedString = solution.decodeString(encodedString);
        System.out.println(decodedString);

//        encodedString = "2[abc]3[cd]ef";
//        decodedString = solution.decodeString(encodedString);
        // Output: "abcabccdcdcdef"
//        System.out.println(decodedString);
    }
}

