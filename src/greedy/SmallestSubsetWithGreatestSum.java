package greedy;

import java.util.*;

public class SmallestSubsetWithGreatestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minSubset(arr, n));
    }

    private static int minSubset(int[] arr, int n) {
        Arrays.sort(arr);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int ct = 0, j = n - 1;
        long s = 0;

        while (j >= 0) {
            s += arr[j];
            ct++;

            if (s > (sum - s)) {
                return ct;
            }
            j--;
        }

        return n;
    }
}
