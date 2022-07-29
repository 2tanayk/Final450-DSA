package dynamicprogramming;

import java.util.*;

public class CoinChangeProblem {
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[m];

        System.out.println(count(arr, m, n));
    }

    public static long count(int arr[], int m, int n) {
        dp = new long[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countWays(arr, m, n);
    }

    private static long countWays(int[] arr, int m, int n) {
        if (n == 0) {
            return 1;
        }

        if (m == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (arr[m - 1] > n) {
            dp[m][n] = countWays(arr, m - 1, n);

            return dp[m][n];
        }

        dp[m][n] = countWays(arr, m - 1, n) + countWays(arr, m, n - arr[m - 1]);

        return dp[m][n];
    }
}
