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
                    /*
                    * for eg.:
                        Lets say the i=10 and our current element is 3 (and assume its the 3rd element),
                        * so if we do NOT take the ceil then we would take dp[i][j]+=dp[3][2] + 1,
                        * this would be wrong as dp[3][2] is the no. of subsequences having prod LESS than 3,
                        * hence we would take ceil(10/3.0) which gives dp[4][2] (4 is excluded so no issues !)
                    * */
                    dp[i][j] += dp[(int) Math.ceil((double) i / arr[j - 1])][j - 1] + 1;
                }
            }
        }

        return dp[k][n];
    }
}
