package graph;

import java.util.*;

public class PrerequisiteTasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        int[][] prereq = new int[nE][2];

        for (int i = 0; i < nE; i++) {
            prereq[i][0] = sc.nextInt();
            prereq[i][1] = sc.nextInt();
        }

        System.out.println(isPossible(nV, prereq));
    }

    public static boolean isPossible(int nV, int[][] edges) {
        int nE = edges.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < nV; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < nE; i++) {
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        return !hasCycle(adj, nV);
    }

    private static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int nV) {
        boolean[] vis = new boolean[nV];
        boolean[] cStack = new boolean[nV];

        for (int i = 0; i < nV; i++) {
            if (!vis[i]) {
                if (dfs(adj, i, vis, cStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, boolean[] s) {
        vis[i] = true;
        s[i] = true;

        for (Integer e : adj.get(i)) {
            if (!vis[e]) {
                if (dfs(adj, e, vis, s)) {
                    return true;
                }
            } else if (s[e]) {
                return true;
            }
        }

        s[i] = false;

        return false;
    }
}
