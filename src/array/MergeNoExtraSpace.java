package array;

import java.util.Scanner;

public class MergeNoExtraSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        mergeSortedArray(arr1, n1, arr2, n2, (int) Math.ceil((n1 + n2) / 2.0));
        printArray(arr1, n1);
        printArray(arr2, n2);
    }

    private static void mergeSortedArray(int[] arr1, int n1, int[] arr2, int n2, int gap) {
        int i, j;
        for (i = 0; i + gap < n1; i++) {
            if (arr1[i] > arr1[i + gap]) {
                swapBetweenArrays(arr1, i, arr1, i + gap);
            }
        }
        for (j = gap > n1 ? gap - n1 : 0; i < n1 && j < n2; i++, j++) {
            if (arr1[i] > arr2[j]) {
                swapBetweenArrays(arr1, i, arr2, j);
            }
        }
        if (j < n2) {
            for (j = 0; j + gap < n2; j++) {
                if (arr2[j] > arr2[j + gap]) {
                    swapBetweenArrays(arr2, j, arr2, j + gap);
                }
            }
        }
        if (gap == 1) {
            return;
        }
        mergeSortedArray(arr1, n1, arr2, n2, (int) Math.ceil(gap / 2.0));
    }

    private static void swapBetweenArrays(int[] arr1, int i, int[] arr2, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
