package searchingandsorting;

import java.util.*;

public class SearchingInArrayAdjacentKDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int x = sc.nextInt();

        System.out.println(search(arr, n, x, k));
    }

    private static int search(int[] arr, int n, int x, int k) {
        for (int i = 0; i < n; ) {
            if (arr[i] == x) {
                return i;
            }

            i += Math.max(1, Math.abs(arr[i] - x) / k);
        }

        return -1;
    }
}
