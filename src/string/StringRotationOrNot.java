package string;

import java.util.Arrays;
import java.util.Scanner;

public class StringRotationOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(isStringRotated(s1, s2, s1.length(), s2.length()));
    }

    private static boolean isStringRotated(String s1, String s2, int n1, int n2) {
        if (n1 != n2) {
            return false;
        }
        s1 = s1 + s1;

        int n = s1.length();
        int m = s2.length();

        int lps[] = computeLPSArray(s2, m);

        int i = 0, j = 0;

        while (i < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private static int[] computeLPSArray(String s, int m) {
        int lps[] = new int[m];
        lps[0] = 0;

        int pLen = 0;

        int i = 1;

        while (i < m) {
            if (s.charAt(i) == s.charAt(pLen)) {
                lps[i] = ++pLen;
                i++;
            } else {

                if (pLen != 0) {
                    pLen = lps[pLen - 1];
                } else {
                    lps[i] = pLen;
                    i++;
                }
            }
        }

        return lps;
    }
}
