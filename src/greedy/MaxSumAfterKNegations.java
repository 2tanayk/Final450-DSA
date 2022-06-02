package greedy;

import java.util.*;

public class MaxSumAfterKNegations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(maximizeSum(arr, n, k));
    }

    private static long maximizeSum(long[] arr, int n, int k) {
        int nCt = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                nCt++;
            }
        }

        if (nCt == k) {
            for (int i = 0; i < n; i++) {
                sum += Math.abs(arr[i]);
            }
        } else if (nCt > k) {
            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                if (k > 0) {
                    sum += Math.abs(arr[i]);
                    k--;
                } else {
                    sum += arr[i];
                }
            }
        } else {
            if ((k - nCt) % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    sum += Math.abs(arr[i]);
                }
            } else {
                long min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (min > Math.abs(arr[i])) {
                        min = Math.abs(arr[i]);
                    }
                    sum += Math.abs(arr[i]);
                }

                sum = sum - 2 * min;
            }
        }

        return sum;
    }
}
