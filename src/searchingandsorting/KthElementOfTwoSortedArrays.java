package searchingandsorting;

import java.util.*;

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(kthElement(arr1, arr2, n, m, k));
    }

    public static long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        if (n > m) {
            return kthElement(arr2, arr1, m, n, k);
        }

        int l = Math.max(0, k - m), r = Math.min(n, k);

        while (l <= r) {
            int cut1 = (l + r) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 > 0 ? arr1[cut1 - 1] : Integer.MIN_VALUE;
            int l2 = cut2 > 0 ? arr2[cut2 - 1] : Integer.MIN_VALUE;

            int r1 = cut1 < n ? arr1[cut1] : Integer.MAX_VALUE;
            int r2 = cut2 < m ? arr2[cut2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                r = cut1 - 1;
            } else {
                l = cut1 + 1;
            }
        }

        return -1;
    }
}
