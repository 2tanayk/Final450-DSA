package array;

import java.util.Scanner;

public class MinimumMergeArrayPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minMergeOps(arr, n));
    }

    private static int minMergeOps(int[] arr, int n) {
        int minOps = 0;
        int i = 0, j = n - 1;

        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] < arr[j]) {
                i++;
                arr[i] += arr[i - 1];
                minOps++;
            } else {
                j--;
                arr[j] += arr[j + 1];
                minOps++;
            }
        }
        return minOps;
    }
}
