package greedy;

import java.util.*;

public class MaxSumOfAbsoluteDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println(maxAbsSum(arr, n));
    }

    private static int maxAbsSum(int[] arr, int n) {
        Arrays.sort(arr);

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        int i = 0, j = n - 1, k = 0;

        int sum = 0;
        sum += Math.abs(arr[i] - arr[j]);
        i++;
        k++;

        while (i < j) {
            sum += Math.abs(arr[i] - arr[j]);
            if (k % 2 == 0) {
                i++;
            } else {
                j--;
            }
            k++;
        }

        sum += Math.abs(arr[0] - arr[j]);

        return sum;
    }
}
