package string;

import java.util.*;

public class LongestPalindromeInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(longestPalin(str));
    }

    private static String longestPalin(String s) {
        int len = s.length();

        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        int start = -1, end = -1;

        for (int i = 0; i < len - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);

            if (ch1 == ch2) {
                dp[i][i + 1] = 1;
                if (start == -1 && end == -1) {
                    start = i;
                    end = i + 2;
                }
            }
        }

        int maxLen = Integer.MIN_VALUE;

        for (int j = 3; j <= len; j++) {
            for (int i = 0; i + j <= len; i++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(i + j - 1);

                if (ch1 == ch2 && dp[i + 1][i + j - 2] == 1) {
                    dp[i][i + j - 1] = 1;
                    if (j > maxLen) {
                        maxLen = j;
                        start = i;
                        end = i + j;
                    }
                }
            }
        }

        if (start == -1 && end == -1) {
            return s.substring(0, 1);
        }

        return s.substring(start, end);
    }
}
