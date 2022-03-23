package array;

import java.util.Scanner;

public class NegativePositiveSegregation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        segregate(arr, n);
        printArray(arr, n);
    }

    private static void segregate(int[] arr, int n) {
        int start = 0, end = n - 1;

        while (start <= end) {
            if (arr[start] < 0 && arr[end] < 0) {
                start++;
            } else if (arr[start] > 0 && arr[end] > 0) {
                end--;
            } else if (arr[start] < 0 && arr[end] > 0) {
                start++;
                end--;
            } else {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
