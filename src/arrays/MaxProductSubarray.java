package arrays;

import java.util.Scanner;

public class MaxProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxProductSubarray(arr, n));
    }

    private static long maxProductSubarray(int[] arr, int n) {
        long maxProd = arr[0];
        long max = maxProd;
        long min = maxProd;

        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                long temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(arr[i], max * arr[i]);
            min = Math.min(arr[i], min * arr[i]);
            maxProd = Math.max(maxProd, max);

        }
        return maxProd;
    }
}
