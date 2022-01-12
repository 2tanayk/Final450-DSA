package arrays;

import java.util.Scanner;

public class RearrangePositiveNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        alternativelyRearrangePositiveNegative(arr, n);
        printArray(arr, n);
    }

    private static void alternativelyRearrangePositiveNegative(int[] arr, int n) {
        int outOfPlaceIndex = -1;

        for (int i = 0; i < n; i++) {
            if (outOfPlaceIndex >= 0) {
                if ((arr[i] < 0 && (outOfPlaceIndex % 2 == 0)) || (arr[i] >= 0 && (outOfPlaceIndex % 2 != 0))) {
                    rightRotateArray(arr, outOfPlaceIndex, i);

                    if (i - outOfPlaceIndex >= 2) {
                        outOfPlaceIndex += 2;
                    } else {
                        outOfPlaceIndex = -1;
                    }
                }
            }

            if (outOfPlaceIndex == -1) {
                if (((i % 2 == 0) && arr[i] >= 0) || ((i % 2 != 0) && arr[i] < 0)) {
                    outOfPlaceIndex = i;
                }
            }
        }
    }

    private static void rightRotateArray(int[] arr, int from, int to) {
        int temp = arr[to];

        for (int i = to; i > from; i--) {
            arr[i] = arr[i - 1];
        }
        arr[from] = temp;
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
