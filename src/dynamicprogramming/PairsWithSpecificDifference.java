package dynamicprogramming;

import java.util.*;

public class PairsWithSpecificDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxSumPairWithDifferenceLessThanK(arr, n, k));
    }

    public static int maxSumPairWithDifferenceLessThanK(int[] arr, int n, int k) {
        if (n == 1) {
            return 0;
        }
        Arrays.sort(arr);

        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = arr[1] - arr[0] < k ? arr[1] + arr[0] : 0;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i] - arr[i - 1] < k) {
                dp[i] = Math.max(dp[i], dp[i - 2] + arr[i] + arr[i - 1]);
            }
        }

        return dp[n - 1];
    }
}
