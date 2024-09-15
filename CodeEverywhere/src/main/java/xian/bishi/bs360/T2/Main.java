package xian.bishi.bs360.T2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String first = sc.next();
            String last = sc.next();
//            boolean res = isYueFen(first, last);
//            System.out.println(res == true ? "YES" : "No");

            String[] one = first.split("/");
            String[] two = last.split("/");
            boolean res2 = isMagicallyEqual(one[0], one[1], two[0], two[1]);
            System.out.println(res2);


        }

    }


    public static boolean isYueFen(String first, String last) {
        String[] one = first.split("/");
        String[] two = last.split("/");
        if (one[0].equals(two[0]) && one[1].equals(two[1])) {
            return true;
        }
        Set<String> firstSet = allPossible(one[0], one[1]);
        Set<String> twoSet = allPossible(two[0], two[1]);
        for (String a : firstSet) {
            if (twoSet.contains(a)) {
                return true;
            }
        }
        return false;
    }

    public static Set<String> allPossible(String s1, String s2) {
        Set<String> result = new HashSet<>();
        result.add(s1 + "/" + s2);

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
//                    进行约分
//                    String a = s1.replaceFirst(Character.toString(s1.charAt(i)), "");
//                    String b = s2.replaceFirst(Character.toString(s2.charAt(j)), "");
                    String a = help(s1, s1.charAt(i));
                    String b = help(s2, s2.charAt(j));
                    if (!a.isEmpty() && !b.isEmpty()) {
                        result.add(a + "/" + b);
                    }
                }
            }
        }
        return result;

    }

    public static String help(String number, char t) {
        return number.replaceFirst(Character.toString(t), "");
    }


    ///

    private static boolean isMagicallyEqual(String a, String b, String c, String d) {
        // If both fractions are already equal
        if (a.equals(c) && b.equals(d)) {
            return true;
        }

        // Generate all possible forms by removing digits
        Set<String> reducedFormsA = generateReducedForms(a, b);
        Set<String> reducedFormsC = generateReducedForms(c, d);

        // Check if any form from the first fraction matches any form from the second fraction
        for (String formA : reducedFormsA) {
            if (reducedFormsC.contains(formA)) {
                return true;
            }
        }

        return false;
    }

    private static Set<String> generateReducedForms(String num1, String num2) {
        Set<String> forms = new HashSet<>();
        forms.add(num1 + "/" + num2); // Include the original form

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                if (num1.charAt(i) == num2.charAt(j)) {
                    String newNum1 = removeDigit(num1, num1.charAt(i));
                    String newNum2 = removeDigit(num2, num2.charAt(j));
                    if (!newNum1.isEmpty() && !newNum2.isEmpty()) {
                        forms.add(newNum1 + "/" + newNum2);
                    }
                }
            }
        }

        return forms;
    }

    private static String removeDigit(String number, char digit) {
        return number.replaceFirst(Character.toString(digit), "");
    }
}









