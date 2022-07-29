package dynamicprogramming;

import java.util.*;

public class BinomialCoefficient {
    static long m = (int) Math.pow(10, 9) + 7;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(nCr(n, r));
    }

    private static int nCr(int n, int r) {
        if (r > n) {
            return 0;
        }

        if (r == 1 || r == n) {
            return n;
        }

        if (n - r < r) {
            r = n - r;
        }

        dp = new long[r + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % m;
            }
        }

        return (int) dp[r];
    }
}
