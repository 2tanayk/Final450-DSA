package array;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printNextPermutation(arr, n);
    }

    private static void printNextPermutation(int[] arr, int n) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int k = n - 2;

        while (k >= 0 && arr[k] >= arr[k + 1]) {
            k--;
        }
        if (k >= 0) {
            int i = n - 1;
            while (arr[i] <= arr[k]) {
                i--;
            }
            swap(arr, i, k);
        }

        reverseArrayInterval(arr, k + 1, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArrayInterval(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private static void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}
