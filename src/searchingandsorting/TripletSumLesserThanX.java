package searchingandsorting;

import java.util.*;

public class TripletSumLesserThanX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        int x = sc.nextInt();

        System.out.println(countTriplets(arr, n, x));
    }

    private static long countTriplets(long[] arr, int n, int sum) {
        Arrays.sort(arr);
        long ct = 0;

        for (int i = 0; i < n - 2; i++) {
            long reqd = sum - arr[i];

            int l = i + 1, h = n - 1;

            while (l < h) {
                long cur = arr[l] + arr[h];

                if (cur < reqd) {
                    ct += (h - l);
                    l++;
                } else {
                    h--;
                }
            }
        }
        return ct;
    }
}
