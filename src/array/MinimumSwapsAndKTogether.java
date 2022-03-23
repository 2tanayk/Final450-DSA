package array;

import java.util.Scanner;

public class MinimumSwapsAndKTogether {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println(minSwaps(arr, n, k));
    }

    private static int minSwaps(int[] arr, int n, int k) {
        int minBad;
        int kCt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                kCt++;
            }
        }

        if (kCt == 0 || kCt == 1) {
            return 0;
        }

        int i = 0, j = i + kCt - 1;
        int badCt = 0;

        for (int l = i; l <= j; l++) {
            if (arr[l] > k) {
                badCt++;
            }
        }
        minBad = badCt;
        if (arr[0] > k) {
            badCt--;
        }

        for (i = 1, j = i + kCt - 1; j < n; i++, j++) {
            if (arr[j] > k) {
                badCt++;
            }
            minBad = Math.min(minBad, badCt);

            if (arr[i] > k) {
                badCt--;
            }
        }

        return minBad;
    }
}
