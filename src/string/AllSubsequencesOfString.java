package string;

import java.util.*;

public class AllSubsequencesOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String s = sc.nextLine();
        int len = s.length();

        printAllSubsequences(0, s, len, "");
    }

    private static void printAllSubsequences(int i, String s, int len, String sub) {
        if (i == len) {
            if (sub.length() == 0) {
                System.out.println("\"\"");
            }
            System.out.println(sub);
            return;
        }

        printAllSubsequences(i + 1, s, len, sub + s.charAt(i));
        printAllSubsequences(i + 1, s, len, sub);
    }
}
