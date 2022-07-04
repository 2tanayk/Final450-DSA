package string;

import java.util.*;

public class MinNumberOfFlipsToAlternateBinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(minFlips(s));
    }

    public static int minFlips(String s) {
        int len = s.length();

        int ct1 = 0;

        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i);
            if (i % 2 == 0 && ch1 != '0') {
                ct1++;
            } else if (i % 2 != 0 && ch1 != '1') {
                ct1++;
            }
        }

        int ct2 = 0;

        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i);
            if (i % 2 == 0 && ch1 != '1') {
                ct2++;
            } else if (i % 2 != 0 && ch1 != '0') {
                ct2++;
            }
        }

        return Math.min(ct1, ct2);
    }
}
