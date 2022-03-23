package array;

import java.util.Scanner;

public class ArrayCyclicRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        cyclicRotation(arr, n);
        printArray(arr, n);
    }

    private static void cyclicRotation(int[] arr, int n) {
        int temp = arr[0];
        arr[0] = arr[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int temp2 = arr[i + 1];
            arr[i + 1] = temp;
            temp = temp2;
        }
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
