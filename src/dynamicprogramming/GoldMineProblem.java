package dynamicprogramming;

import java.util.*;

public class GoldMineProblem {
    static int[][] dp;

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

        System.out.println(maxGold(n, m, arr));
    }

    static int maxGold(int n, int m, int[][] arr) {
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, max(arr, i, 0));
        }

        return max;
    }

    static int max(int[][] arr, int i, int j) {
        int n = arr.length;
        int m = arr[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int[][] ops = {{-1, 1}, {0, 1}, {1, 1}};

        int max = Integer.MIN_VALUE;

        for (int k = 0; k < 3; k++) {
            max = Math.max(max, max(arr, i + ops[k][0], j + ops[k][1]));
        }

        dp[i][j] = arr[i][j] + max;

        return dp[i][j];
    }
}
