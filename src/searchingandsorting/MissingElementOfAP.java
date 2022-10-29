package searchingandsorting;

import java.util.*;

public class MissingElementOfAP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMissing(arr, n));
    }

    static int findMissing(int[] arr, int n) {
        if (n == 2) {
            return arr[0] + (arr[1] - arr[0]) / 2;
        }


        int d = arr[1] - arr[0];

        if (d != arr[n - 1] - arr[n - 2]) {
            if (d > arr[n - 1] - arr[n - 2]) {
                return arr[0] + d / 2;
            } else {
                return arr[n - 2] + d;
            }
        }

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == arr[0] + mid * d) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return arr[0] + l * d;
    }
}
