package dynamicprogramming;

import java.util.*;

public class FriendsPairingProblem {
    static long m = (int) Math.pow(10, 9) + 7;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countFriendsPairings(n));
    }

    public static long countFriendsPairings(int n) {
        dp = new long[n + 1];

        Arrays.fill(dp, -1);

        return count(n);
    }

    private static long count(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = (count(n - 1) % m + (n - 1) * count(n - 2) % m) % m;

        return dp[n];
    }
}
