package dynamicprogramming;

import java.util.*;

public class RodCuttingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(cutRod(arr, n));
    }

    static int[][] dp;

    public static int cutRod(int[] arr, int n) {
        dp = new int[n + 1][n];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxVal(arr, n, 0);
    }

    private static int maxVal(int[] arr, int len, int i) {
        int n = arr.length;

        if (len == 0 || i == n) {
            return 0;
        }

        if (dp[len][i] != -1) {
            return dp[len][i];
        }

        if (i + 1 > len) {
            return dp[len][i] = maxVal(arr, len, i + 1);
        }

        return dp[len][i] = Math.max(arr[i] + maxVal(arr, len - i - 1, i), maxVal(arr, len, i + 1));
    }
}
