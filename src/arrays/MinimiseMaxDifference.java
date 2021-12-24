package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimiseMaxDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minimiseMaxDifference(arr, n, k));
    }

    private static int minimiseMaxDifference(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int minDifference = arr[n - 1] - arr[0];

        int smallest = arr[0] + k, largest = arr[n - 1] - k;
        int minHeight, maxHeight;

        for (int i = 0; i < n - 1; i++) {
            minHeight = Math.min(smallest, arr[i + 1] - k);
            maxHeight = Math.max(largest, arr[i] + k);
            if (!(minHeight < 0)) {
                minDifference = Math.min(minDifference, maxHeight - minHeight);
            }
        }
        return minDifference;
    }
}
