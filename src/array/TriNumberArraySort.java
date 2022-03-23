package array;

import java.util.Scanner;

public class TriNumberArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dnfSort(arr, n);
        printArray(arr, n);
    }

    private static void dnfSort(int[] arr, int n) {
        int low = 0, high = n - 1;
        int mid = low;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
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
