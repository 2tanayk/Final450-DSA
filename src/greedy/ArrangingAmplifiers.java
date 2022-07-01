package greedy;

import java.io.*;
import java.util.*;

public class ArrangingAmplifiers {
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

        int t = f.nextInt();

        while (t-- > 0) {
            int n = f.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = f.nextInt();
            }

            maxAmplification(arr, n);

            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static void maxAmplification(int[] arr, int n) {
        int ct1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                int temp = arr[ct1];
                arr[ct1] = 1;
                arr[i] = temp;

                ct1++;
            }
        }

        Arrays.sort(arr, ct1, n);

        int i = ct1, j = n - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        if (n - ct1 == 2 && arr[ct1] == 3 && arr[ct1 + 1] == 2) {
            int temp = arr[ct1];
            arr[ct1] = arr[ct1 + 1];
            arr[ct1 + 1] = temp;
        }
    }
}
