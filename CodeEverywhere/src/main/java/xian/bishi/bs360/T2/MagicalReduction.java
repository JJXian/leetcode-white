package xian.bishi.bs360.T2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 1
 * 114514/1919810 1454/91980
 */
public class MagicalReduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
//        scanner.nextLine(); // Consume new line

        for (int t = 0; t < T; t++) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String fraction1 = parts[0];
            String fraction2 = parts[1];

            String[] nums1 = fraction1.split("/");
            String[] nums2 = fraction2.split("/");

            String a = nums1[0];
            String b = nums1[1];
            String c = nums2[0];
            String d = nums2[1];

            if (isMagicallyEqual(a, b, c, d)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scanner.close();
    }

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