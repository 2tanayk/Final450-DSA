package dynamicprogramming;

import java.util.*;

public class IsEqualSumSubsetPossible {
    static boolean[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println();
    }

    static int equalPartition(int n, int[] arr) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return 0;
        }

        dp = new boolean[n + 1][sum / 2 + 1];

        return isPartitionPossible(arr, n, sum / 2) ? 1 : 0;
    }

    private static boolean isPartitionPossible(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (arr[n - 1] > sum) {
            dp[n][sum] = isPartitionPossible(arr, n - 1, sum);

            return dp[n][sum];
        }

        dp[n][sum] = isPartitionPossible(arr, n - 1, sum - arr[n - 1]) || isPartitionPossible(arr, n - 1, sum);

        return dp[n][sum];
    }
}
