package dynamicprogramming;

import java.util.*;

public class MatrixChainMultiplication {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(matrixMultiplication(n, arr));
    }

    private static int matrixMultiplication(int n, int[] arr) {
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(arr, 1, n - 1);
    }

    private static int solve(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            min = Math.min(min, solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j]);
        }

        dp[i][j] = min;

        return dp[i][j];
    }
}
