package arrays;

import java.util.Scanner;

public class LargestContinuousSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxSumSubarray(arr, n));
    }

    private static int maxSumSubarray(int[] arr, int n) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
