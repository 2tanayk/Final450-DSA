package string;

import java.util.*;

public class Transfiguration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(transfigure(s1, s2));
    }

    private static int transfigure(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return -1;
        }

        int len = str1.length();

        int i, j;
        int[] count = new int[256];

        for (i = 0; i < len; i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }

        for (i = 0; i < 256; i++) {
            if (count[i] != 0)
                return -1;
        }

        int ct = 0;

        i = len - 1;
        j = len - 1;

        while (i >= 0) {
            int ch1 = str1.charAt(i);
            int ch2 = str2.charAt(j);

            if (ch1 == ch2) {
                i--;
                j--;
            } else {
                ct++;
                i--;
            }
        }

        return ct;
    }
}
