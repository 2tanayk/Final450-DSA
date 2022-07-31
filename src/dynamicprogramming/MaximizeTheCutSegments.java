package dynamicprogramming;

import java.util.*;

public class MaximizeTheCutSegments {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        System.out.println(maximizeCuts(n, x, y, z));
    }

    public static int maximizeCuts(int n, int x, int y, int z) {
        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        int res = calcMax(n, x, y, z);

        return Math.max(res, 0);
    }

    private static int calcMax(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int max = Integer.MIN_VALUE;
        if (n >= x) {
            max = Math.max(max, calcMax(n - x, x, y, z));
        }

        if (n >= y) {
            max = Math.max(max, calcMax(n - y, x, y, z));
        }

        if (n >= z) {
            max = Math.max(max, calcMax(n - z, x, y, z));
        }

        dp[n] = 1 + max;

        return dp[n];
    }
}
