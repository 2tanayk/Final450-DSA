package greedy;

import java.io.*;
import java.util.*;

public class PickingUpChicks {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();

        int t = f.nextInt(), ct = 1;

        while (t-- > 0) {
            int n = f.nextInt();
            int k = f.nextInt();
            int b = f.nextInt();
            int time = f.nextInt();

            int[] x = new int[n];
            int[] v = new int[n];

            for (int i = 0; i < n; i++) {
                x[i] = f.nextInt();
            }

            for (int i = 0; i < n; i++) {
                v[i] = f.nextInt();
            }

            int ans = minSwaps(n, k, b, time, x, v);
            System.out.println("Case #" + ct + ": " + (ans == -1 ? "IMPOSSIBLE" : ans));
            ct++;
        }
    }

    private static int minSwaps(int n, int k, int b, int time, int[] x, int[] v) {
        int ct = 0, swaps = 0, i, cantCt = 0;
        for (i = n - 1; i >= 0; i--) {
            int xi = x[i];
            int vi = v[i];

            if (xi + vi * time >= b) {
                ct++;
            } else {
                break;
            }

        }

        if (ct >= k) {
            return 0;
        }

        for (; i >= 0; i--) {
            int xi = x[i];
            int vi = v[i];

            if (xi + vi * time < b) {
                cantCt++;
            } else {
                swaps += cantCt;
                ct++;

                if (ct == k) {
                    break;
                }
            }
        }

        return ct < k ? -1 : swaps;
    }
}
