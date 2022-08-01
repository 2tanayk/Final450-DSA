package dynamicprogramming;

import java.util.*;

public class MaxSumNoTwoAdjacent {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMaxSum(arr, n));
    }

    private static int findMaxSum(int[] arr, int n) {
        dp = new int[n + 1];

        Arrays.fill(dp, -1);
        return maxSum(arr, n);
    }

    private static int maxSum(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = Math.max(arr[n - 1] + maxSum(arr, n - 2), maxSum(arr, n - 1));
        return dp[n];
    }
}
