package searchingandsorting;

import java.util.*;

public class AllocateMinNumberOfPages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        System.out.println(findPages(arr, n, m));
    }

    public static int findPages(int[] arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int l = arr[0];

        int r = 0;

        for (int i = 0; i < n; i++) {
            r += arr[i];
        }

        int minP = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (isPossible(arr, mid, m)) {
                minP = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return minP;
    }

    private static boolean isPossible(int[] arr, int x, int m) {
        int i = 0, ct = 0, cur = 0;

        while (i < arr.length) {
            if (arr[i] > x) {
                return false;
            }

            if (cur + arr[i] <= x) {
                cur += arr[i++];
            } else {
                ct++;
                cur = 0;

                if (ct > m) {
                    return false;
                }
            }
        }

        return cur <= 0 || ct + 1 <= m;
    }
}
