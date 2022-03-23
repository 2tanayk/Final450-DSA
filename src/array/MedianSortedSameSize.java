package array;

import java.util.Scanner;

public class MedianSortedSameSize {
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

        System.out.println(findMedian(arr1, arr2, 0, n1 - 1, 0, n2 - 1));

    }

    private static int findMedian(int[] arr1, int[] arr2, int i1Start, int i1End, int i2Start, int i2End) {
        if (i1End - i1Start <= 1 && i2End - i2Start <= 1) {
            return (Math.max(arr1[i1Start], arr2[i2Start]) + Math.min(arr1[i1End], arr2[i2End])) / 2;
        }

        int m1 = median(arr1, i1Start, i1End);
        int m2 = median(arr2, i2Start, i2End);

        if (m1 == m2) {
            return m1;
        } else if (m1 > m2) {
            return findMedian(arr1, arr2, i1Start, (i1Start + i1End + 1) / 2, (i2Start + i2End + 1) / 2, i2End);
        } else {
            return findMedian(arr1, arr2, (i1Start + i1End + 1) / 2, i1End, i2Start, (i2Start + i2End + 1) / 2);
        }
    }

    private static int median(int arr[], int i, int j) {
        return (arr[(i + j) / 2] + arr[(i + j + 1) / 2]) / 2;
    }
}
