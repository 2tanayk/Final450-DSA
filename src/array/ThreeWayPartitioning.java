package array;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeWayPartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] range = new int[2];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 2; i++) {
            range[i] = sc.nextInt();
        }

        int pos = partition(arr, n, 0, range[0]);
        int tPos = pos;
        for (int i = 0; i <= pos - 1; i++) {
            if (arr[i] == range[0]) {
                while (tPos >= 0) {
                    if (!(arr[tPos] >= range[0])) {
                        swap(arr, tPos, i);
                        tPos--;
                        break;
                    } else {
                        tPos--;
                    }
                }
            }
        }
        pos = partition(arr, n, pos + 1, range[1]);

        for (int i = pos + 1; i < n; i++) {
            if (arr[i] == range[1]) {
                swap(arr, i, pos + 1);
                pos++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int n, int start, int pivot) {
        int i = start, j = n - 1;

        while (i <= j) {
            while (i <= n - 1 && arr[i] < pivot) {
                i++;
            }

            while (j >= 0 && arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}