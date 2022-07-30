package dynamicprogramming;

import java.math.*;
import java.util.*;

public class NthCatalanNumber {
    static BigInteger[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(findCatalan(n));
    }

    public static BigInteger findCatalan(int n) {
        dp = new BigInteger[n + 1];

        Arrays.fill(dp, new BigInteger("-1"));

        return nthCatalan(n);
    }

    public static BigInteger nthCatalan(int n) {
        if (n == 0 || n == 1) {
            return new BigInteger("1");
        }

        if (!dp[n].equals(new BigInteger("-1"))) {
            return dp[n];
        }

        BigInteger cur = new BigInteger("0");

        for (int i = 0; i < n; i++) {
            cur = cur.add(nthCatalan(i).multiply(nthCatalan(n - i - 1)));
        }

        dp[n] = cur;

        return dp[n];
    }
}
