package graph;

import java.util.*;

public class PathGreaterThanEqualToK {
    static class Pair {
        int dest, wt;

        Pair(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        int k = sc.nextInt();

        int edges[] = new int[3 * nE];

        System.out.println(pathMoreThanK(nV, nE, k, edges));
    }

    private static boolean pathMoreThanK(int nV, int nE, int k, int[] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(nV);

        for (int i = 0; i < nV; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i + 2 < edges.length; i += 3) {
            int src = edges[i];
            int dest = edges[i + 1];
            int wt = edges[i + 2];

            adj.get(src).add(new Pair(dest, wt));
            adj.get(dest).add(new Pair(src, wt));
        }

        boolean[] vis = new boolean[nV];

        return dfs(adj, 0, vis, k);
    }

    private static boolean dfs(ArrayList<ArrayList<Pair>> adj, int i, boolean[] vis, int k) {
        vis[i] = true;

        if (k <= 0) {
            return true;
        }

        for (Pair p : adj.get(i)) {
            int dest = p.dest;
            int wt = p.wt;

            if (!vis[dest]) {
                if (dfs(adj, dest, vis, k - wt)) {
                    return true;
                }
            }
        }

        vis[i] = false;

        return false;
    }
}
