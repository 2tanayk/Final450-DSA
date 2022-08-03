package dynamicprogramming;

import java.util.*;

public class LargestSquareFormedInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxSquare(n, m, arr));
    }

    private static int maxSquare(int n, int m, int[][] arr) {
        int max = 0;

        int[][] dp = new int[n + 1][m + 1];

        Arrays.fill(dp[0], 0);

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
