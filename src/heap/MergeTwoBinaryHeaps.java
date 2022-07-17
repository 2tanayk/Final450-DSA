package heap;

import java.util.*;

public class MergeTwoBinaryHeaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(mergeHeaps(arr1, arr2, n, m)));
    }

    private static int[] mergeHeaps(int[] h1, int[] h2, int n, int m) {
        int[] merged = new int[n + m];

        int i;
        for (i = 0; i < n; i++) {
            merged[i] = h1[i];
        }

        for (int j = 0; j < m; j++) {
            merged[i++] = h2[j];
        }

        for (i = (n + m) / 2 - 1; i >= 0; i--) {
            heapify(merged, i, n + m);
        }

        return merged;
    }

    public static void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }

        if (right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, largest, n);
        }
    }
}
