package arrays;

import java.util.Scanner;

public class SmallestSubarrayWithSumGreaterThanX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findSmallestSubarrayWithSumGreaterThanX(arr, n, x));
    }

    private static int findSmallestSubarrayWithSumGreaterThanX(int[] arr, int n, int x) {
        int len = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;

        while (i <= j && j < n) {
            while (sum <= x && j < n) {
                sum += arr[j++];
            }

            while (sum > x && i < j) {
                len = Math.min(len, (j - i));
                sum -= arr[i];
                i++;
            }
        }
        return len;
    }
}
