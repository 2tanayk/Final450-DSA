package dynamicprogramming;

import java.util.*;

public class MaxLengthPairsChain {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        System.out.println(maxChainLength(arr, n));
    }

    static int[][] dp;

    private static int maxChainLength(Pair[] arr, int n) {
        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        Arrays.sort(arr, (p1, p2) -> p1.x - p2.x);

        return maxLen(arr, 0, -1);
    }

    private static int maxLen(Pair[] arr, int i, int prev) {
        int n = arr.length;

        if (i == n) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        if (prev == -1 || arr[prev].y < arr[i].x) {
            return dp[i][prev + 1] = Math.max(1 + maxLen(arr, i + 1, i), maxLen(arr, i + 1, prev));
        }

        return dp[i][prev + 1] = maxLen(arr, i + 1, prev);
    }
}
