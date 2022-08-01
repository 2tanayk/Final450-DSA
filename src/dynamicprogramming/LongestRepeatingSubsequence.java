package dynamicprogramming;

import java.util.*;

public class LongestRepeatingSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(LongestRepeatingSubsequence(s));
    }

    public static int LongestRepeatingSubsequence(String s) {
        int n = s.length();
        String cpy = s;

        dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lrs(s, n, cpy, n);
    }

    private static int lrs(String s1, int n, String s2, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1) && n != m) {
            dp[n][m] = 1 + lrs(s1, n - 1, s2, m - 1);
            return dp[n][m];
        }

        dp[n][m] = Math.max(lrs(s1, n - 1, s2, m), lrs(s1, n, s2, m - 1));

        return dp[n][m];
    }
}
