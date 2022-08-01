package dynamicprogramming;

import java.util.*;

public class LISWithAdjacentDifferenceOfOne {
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
        return longest(arr, 0, -1);
    }

    private static int longest(int[] arr, int i, int prev) {
        int n = arr.length;
        if (i == n) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        if (prev == -1 || Math.abs(arr[i] - arr[prev]) == 1) {
            dp[i][prev + 1] = Math.max(1 + longest(arr, i + 1, i), longest(arr, i + 1, prev));
            return dp[i][prev + 1];
        }

        dp[i][prev + 1] = longest(arr, i + 1, prev);

        return dp[i][prev + 1];
    }
}
