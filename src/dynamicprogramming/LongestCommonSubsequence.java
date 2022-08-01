package dynamicprogramming;

import java.util.*;

public class LongestCommonSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(lcs(s1.length(), s2.length(), s1, s2));
    }

    private static int lcs(int n, int m, String s1, String s2) {
        dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findLCS(s1, n, s2, m);
    }

    private static int findLCS(String s1, int n, String s2, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + findLCS(s1, n - 1, s2, m - 1);
            return dp[n][m];
        }

        dp[n][m] = Math.max(findLCS(s1, n - 1, s2, m), findLCS(s1, n, s2, m - 1));

        return dp[n][m];
    }
}
