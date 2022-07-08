package graph;

import java.util.*;

public class MinTimeTakenByEachJob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        int[][] edges = new int[nE][2];

        for (int i = 0; i < nE; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.println(Arrays.toString(minimumTime(nV, nE, edges)));
    }

    public static int[] minimumTime(int nV, int nE, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(nV);


        for (int i = 0; i <= nV; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < nE; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        return minTimeForJobs(adj, nV);
    }

    private static int[] minTimeForJobs(ArrayList<ArrayList<Integer>> adj, int nV) {
        int[] time = new int[nV + 1];

        int[] in = new int[nV + 1];

        for (int i = 1; i <= nV; i++) {
            for (Integer e : adj.get(i)) {
                in[e]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int t = 1;

        for (int i = 1; i <= nV; i++) {
            if (in[i] == 0) {
                time[i] = t;
                q.add(i);
            }
        }

        t++;

        while (!q.isEmpty()) {
            int ct = q.size();

            while (ct-- > 0) {
                Integer cur = q.poll();

                for (Integer e : adj.get(cur)) {
                    in[e]--;

                    if (in[e] == 0) {
                        time[e] = t;
                        q.add(e);
                    }
                }
            }

            t++;
        }

        return Arrays.copyOfRange(time, 1, nV + 1);
    }
}
