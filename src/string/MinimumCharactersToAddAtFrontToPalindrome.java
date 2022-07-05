package string;

import java.util.*;

public class MinimumCharactersToAddAtFrontToPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(minChar(s));
    }

    public static int minChar(String str) {
        int ogLen = str.length();

        str = str + "$" + new StringBuilder(str).reverse().toString();

        int len = str.length();

        int[] lps = new int[len];


        int i = 0, lpsLen = 0;
        lps[i] = 0;
        i++;

        while (i < len) {
            char ci = str.charAt(i);
            char cl = str.charAt(lpsLen);

            if (ci == cl) {
                lps[i++] = ++lpsLen;
            } else if (lpsLen != 0) {
                lpsLen = lps[--lpsLen];
            } else {
                lps[i++] = 0;
            }
        }

        if (lps[len - 1] == 0) {
            lps[len - 1]++;
        }

        return ogLen - lps[len - 1];
    }
}
