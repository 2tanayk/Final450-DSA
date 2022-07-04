package dynamicprogramming;

import java.util.*;

public class WordWrap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(solveWordWrap(arr, k));
    }

    private static int solveWordWrap(int[] arr, int k) {
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = k - arr[i];

            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] - arr[j] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] < 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (j == n - 1 && dp[i][j] > 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j] * dp[i][j];
                }


            }
        }

        int[] cost = new int[n];

        Arrays.fill(cost, Integer.MAX_VALUE);


        for (int i = n - 1; i >= 0; i--) {
            cost[i] = dp[i][n - 1];
            for (int j = n - 1; j > i; j--) {
                if (dp[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }

                if (cost[i] > dp[i][j - 1] + cost[j]) {
                    cost[i] = dp[i][j - 1] + cost[j];
                }
            }
        }

        return cost[0];
    }
}
