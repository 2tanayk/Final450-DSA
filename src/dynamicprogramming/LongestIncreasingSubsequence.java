package dynamicprogramming;

import java.util.*;

public class LongestIncreasingSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(longestSubsequence(n, arr));
    }

    private static int longestSubsequence(int n, int arr[]) {
        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lis(arr, 0, -1);
    }

    private static int lis(int[] arr, int i, int prev) {
        int n = arr.length;

        if (i == n) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        if (prev == -1 || arr[i] > arr[prev]) {
            dp[i][prev + 1] = Math.max(lis(arr, i + 1, prev), 1 + lis(arr, i + 1, i));
            return dp[i][prev + 1];
        }

        dp[i][prev + 1] = lis(arr, i + 1, prev);

        return dp[i][prev + 1];
    }
}
