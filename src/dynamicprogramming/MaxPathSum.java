package dynamicprogramming;

import java.util.*;

public class MaxPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(maximumPath(n, arr));
    }

    static int[][] dp;

    static int maximumPath(int n, int[][] arr) {
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, solve(arr, 0, i));
        }
        return max;
    }

    private static int solve(int[][] arr, int i, int j) {
        int n = arr.length;
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = arr[i][j] + Math.max(solve(arr, i + 1, j - 1), Math.max(solve(arr, i + 1, j), solve(arr, i + 1, j + 1)));
    }
}
