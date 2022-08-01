package dynamicprogramming;

import java.util.*;

public class MaxSumIncreasingSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxSumIS(arr, n));
    }

    public static int maxSumIS(int[] arr, int n) {
        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxSum(arr, 0, -1);
    }

    private static int maxSum(int[] arr, int i, int prev) {
        int n = arr.length;
        if (i == n) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }


        if (prev == -1 || arr[i] > arr[prev]) {
            dp[i][prev + 1] = Math.max(arr[i] + maxSum(arr, i + 1, i), maxSum(arr, i + 1, prev));
            return dp[i][prev + 1];
        }

        dp[i][prev + 1] = maxSum(arr, i + 1, prev);

        return dp[i][prev + 1];
    }
}
