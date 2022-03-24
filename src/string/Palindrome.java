package string;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(isPalindrome(str, str.length()));

    }

    private static String isPalindrome(String s, int n) {
        int i = 0, j = n - 1;

        while (i < j) {
            char start = s.charAt(i);
            char end = s.charAt(j);

            if (start != end) {
                return "S is not a palindrome";
            }
            i++;
            j--;
        }

        return "S is a palindrome";
    }
}
