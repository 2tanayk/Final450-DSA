package dynamicprogramming;

import java.util.*;

public class LCSofThreeStrings {
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();

        System.out.println(LCSof3(s1, s2, s3, s1.length(), s2.length(), s3.length()));
    }

    private static int LCSof3(String s1, String s2, String s3, int n1, int n2, int n3) {
        dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }


        return lcs(s1, n1, s2, n2, s3, n3);
    }

    private static int lcs(String s1, int n1, String s2, int n2, String s3, int n3) {
        if (n1 == 0 || n2 == 0 || n3 == 0) {
            return 0;
        }

        if (dp[n1][n2][n3] != -1) {
            return dp[n1][n2][n3];
        }

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1) && s2.charAt(n2 - 1) == s3.charAt(n3 - 1)) {
            dp[n1][n2][n3] = 1 + lcs(s1, n1 - 1, s2, n2 - 1, s3, n3 - 1);

            return dp[n1][n2][n3];
        }

        dp[n1][n2][n3] = Math.max(lcs(s1, n1 - 1, s2, n2, s3, n3), Math.max(lcs(s1, n1, s2, n2 - 1, s3, n3), lcs(s1, n1, s2, n2, s3, n3 - 1)));
        return dp[n1][n2][n3];
    }
}
