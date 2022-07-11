package graph;

import java.io.*;
import java.util.*;

class OliverAndTheGame {
    static int time = 1;

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

    public static void main(String args[]) throws Exception {
        FastReader f = new FastReader();

        int nV = f.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(nV + 1);

        for (int i = 0; i <= nV; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= nV - 1; i++) {
            int a = f.nextInt();
            int b = f.nextInt();

            try {
                adj.get(a).add(b);
                adj.get(b).add(a);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        int[] inTime = new int[nV + 1];
        int[] outTime = new int[nV + 1];
        boolean[] vis = new boolean[nV + 1];

        dfs(adj, 1, 0, inTime, outTime);

        int queries = f.nextInt();

        while (queries-- > 0) {
            int flag = f.nextInt();
            int x = f.nextInt();
            int y = f.nextInt();


            if (!check(x, y, inTime, outTime) && !check(y, x, inTime, outTime)) {
                System.out.println("NO");
                continue;
            }

            String ans = "NO";
            if (flag == 0) {
                if (check(y, x, inTime, outTime)) {
                    ans = "YES";
                }
            } else {
                if (check(x, y, inTime, outTime)) {
                    ans = "YES";
                }
            }

            System.out.println(ans);
        }

    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int i, int parent, int[] inTime, int[] outTime) {

        inTime[i] = time++;

        for (Integer e : adj.get(i)) {
            if (e != parent) {
                dfs(adj, e, i, inTime, outTime);
            }
        }

        outTime[i] = time++;
    }

    private static boolean check(int x, int y, int[] inTime, int[] outTime) {
        return inTime[x] > inTime[y] && outTime[x] < outTime[y];
    }

}
