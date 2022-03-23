package array;

import java.util.Scanner;

public class CountInversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] tempArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(mergeSort(arr, tempArr, 0, n - 1));
    }

    private static int mergeSort(int[] arr, int[] tempArr, int left, int right) {
        int mid, inversions = 0;
        if (right > left) {
            mid = (left + right) / 2;

            inversions += mergeSort(arr, tempArr, left, mid);
            inversions += mergeSort(arr, tempArr, mid + 1, right);

            inversions += mergeArray(arr, tempArr, left, mid + 1, right);
        }
        return inversions;
    }

    private static int mergeArray(int[] arr, int[] tempArr, int left, int mid, int right) {
        int i, j, k;
        int inversions = 0;

        i = left;
        j = mid;
        k = left;

        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];

                inversions += (mid - i);
            }
        }

        while (i <= mid - 1) {
            tempArr[k++] = arr[i++];
        }

        while (j <= right) {
            tempArr[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = tempArr[i];
        }

        return inversions;
    }
}
