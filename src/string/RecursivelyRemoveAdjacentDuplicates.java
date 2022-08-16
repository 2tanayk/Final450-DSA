package string;

import java.util.*;

public class RecursivelyRemoveAdjacentDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(rremove(s));
    }

    static String rremove(String s) {
        return rmAdjacent(new StringBuilder(s));
    }

    private static String rmAdjacent(StringBuilder s) {
        String og = s.toString();

        int i = 0;

        while (i + 1 < s.length()) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                char ch = s.charAt(i);
                while (i < s.length() && s.charAt(i) == ch) {
                    s.deleteCharAt(i);
                }
                continue;
            }

            i++;
        }

        if (og.equals(s.toString()) || s.length() == 0) {
            return s.toString();
        }

        return rmAdjacent(s);
    }
}
