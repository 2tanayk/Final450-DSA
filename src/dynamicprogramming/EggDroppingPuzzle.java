package dynamicprogramming;

import java.util.*;

public class EggDroppingPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(eggDrop(n, k));
    }

    static int[][] dp;

    private static int eggDrop(int n, int k) {
        dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return requiredAttempts(n, k);
    }

    private static int requiredAttempts(int n, int k) {
        if (k == 0 || k == 1) {
            return k;
        }

        if (n == 1) {
            return k;
        }

        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            min = Math.min(min, 1 + Math.max(requiredAttempts(n - 1, i - 1), requiredAttempts(n, k - i)));
        }

        dp[n][k] = min;

        return dp[n][k];
    }
}
