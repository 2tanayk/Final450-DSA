package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GergoviaWineTrading {
    static class Pair {
        int element, index;

        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }
    }

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

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        FastReader sc = new FastReader();

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(minWork(arr, n));
        }
    }

    private static int minWork(int[] arr, int n) {
        int work = 0;
        ArrayList<Pair> buy = new ArrayList<>();
        ArrayList<Pair> sell = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                buy.add(new Pair(arr[i], i));
            } else {
                sell.add(new Pair(arr[i], i));
            }
        }

        int i = 0, j = 0;

        while (i < buy.size() && j < sell.size()) {
            Pair bi = buy.get(i);
            Pair si = sell.get(j);

            int f = Math.min(bi.element, -si.element);

            buy.set(i, new Pair(bi.element - f, bi.index));
            sell.set(j, new Pair(si.element + f, si.index));

            work += Math.abs(bi.index - si.index) * f;

            if (i < buy.size() && buy.get(i).element == 0) {
                i++;
            }

            if (j < sell.size() && sell.get(j).element == 0) {
                j++;
            }
        }

        return work;
    }
}
