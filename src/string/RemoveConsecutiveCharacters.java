package string;

import java.util.*;

public class RemoveConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(removeConsecutiveCharacter(s));
    }

    private static String removeConsecutiveCharacter(String s) {
        int len = s.length();

        return remove(s, len, 0);
    }

    private static String remove(String s, int len, int i) {
        if (i == len - 1) {
            return s.charAt(len - 1) + "";
        }

        String ans = remove(s, len, i + 1);

        return ans.charAt(0) == s.charAt(i) ? ans : s.charAt(i) + ans;
    }
}
