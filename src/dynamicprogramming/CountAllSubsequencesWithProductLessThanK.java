package dynamicprogramming;

import java.util.*;

public class CountAllSubsequencesWithProductLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        //only +ve nos
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(count(arr, n, k));
    }

    private static int count(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];

        Arrays.fill(dp[0], 0);

        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                if (arr[j - 1] < i) {
                    dp[i][j] += dp[(int) Math.ceil((double) i / arr[j - 1])][j - 1] + 1;
                }
            }
        }


        return dp[k][n];
    }
}
