package dynamicprogramming;

import java.util.*;

public class ZeroOneKnapsackProblem {
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        int cap = sc.nextInt();

        System.out.println(maxProfit(wt, val, cap, n));
    }

    private static int maxProfit(int[] wt, int[] val, int cap, int n) {
        if (n == 0 || cap == 0) {
            return 0;
        }

        if (dp[n][cap] != -1) {
            return dp[n][cap];
        }

        if (wt[n - 1] > cap) {
            dp[n][cap] = maxProfit(wt, val, cap, n - 1);
            return dp[n][cap];
        }

        dp[n][cap] = Math.max(val[n - 1] + maxProfit(wt, val, cap - wt[n - 1], n - 1), maxProfit(wt, val, cap, n - 1));

        return dp[n][cap];
    }
}
