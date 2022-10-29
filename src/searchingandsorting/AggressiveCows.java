package searchingandsorting;

import java.util.*;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(solve(n, k, dist));
    }

    public static int solve(int n, int k, int[] d) {
        Arrays.sort(d);

        int l = Integer.MAX_VALUE;
        int r = d[n - 1] - d[0];

        for (int i = 1; i < n; i++) {
            l = Math.min(l, d[i] - d[i - 1]);
        }

        int maxD = Integer.MIN_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (isPossible(d, mid, k)) {
                maxD = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return maxD;
    }

    private static boolean isPossible(int[] d, int x, int k) {
        int i = 1;
        int prev = d[0];

        k--;

        while (k > 0 && i < d.length) {
            if (d[i] - prev >= x) {
                k--;
                prev = d[i];
            }

            i++;
        }

        return k == 0;
    }
}
