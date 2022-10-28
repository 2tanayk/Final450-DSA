package searchingandsorting;

import java.util.*;

public class KthSmallestNumberAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            long[][] range = new long[n][2];

            for (int i = 0; i < n; i++) {
                range[i][0] = sc.nextLong();
                range[i][1] = sc.nextLong();
            }

            Arrays.sort(range, (o1, o2) -> Long.compare(o1[0], o2[0]));

            List<long[]> arr = new ArrayList<>();
            List<Long> pref = new ArrayList<>();
            long ct = 0;

            long s = range[0][0];
            long e = range[0][1];

            for (int i = 0; i < n - 1; i++) {
                if (e >= range[i + 1][0]) {
                    s = Math.min(s, range[i + 1][0]);
                    e = Math.max(e, range[i + 1][1]);
                } else {
                    arr.add(new long[]{s, e});
                    ct += (e - s + 1);
                    pref.add(ct);

                    s = range[i + 1][0];
                    e = range[i + 1][1];
                }
            }

            arr.add(new long[]{s, e});
            ct += (e - s + 1);
            pref.add(ct);

            while (q > 0) {
                long k = sc.nextLong();
                long ans = k > ct ? -1 : kthSmallest(arr, pref, k);
                System.out.println(ans);
                q--;
            }

            t--;
        }
    }

    private static long kthSmallest(List<long[]> arr, List<Long> pref, long k) {
        int l = 0, r = pref.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            long[] tmp = arr.get(m);

            if (pref.get(m) == k) {
                return tmp[1];
            } else if (pref.get(m) > k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }


        long[] tmp = arr.get(r + 1);

        if (r == -1) {
            return tmp[0] + k - 1;
        }

        return tmp[0] + (k - pref.get(r) - 1);
    }
}


