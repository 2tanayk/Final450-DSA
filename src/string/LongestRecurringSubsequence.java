package string;

import java.util.*;

public class LongestRecurringSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(longestCommonSubsequence(str));
    }

    public static int longestCommonSubsequence(String str) {
        int len = str.length();

        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            char c1 = str.charAt(i - 1);
            for (int j = 1; j <= len; j++) {
                char c2 = str.charAt(j - 1);
                if (c1 == c2 && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[len][len];
    }
}
