package graph;

import java.util.*;

public class IsBridgeEdge {
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nV);

        for (int i = 0; i < nV; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= nE; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();

            addEdge(adjList, source, destination);
        }

        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(isBridge(nV, adjList, c, d));
    }

    static int isBridge(int nV, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        int[] low = new int[nV];
        Arrays.fill(low, -1);
        int[] disc = new int[nV];
        Arrays.fill(disc, -1);
        int[] parent = new int[nV];
        Arrays.fill(parent, -1);

        boolean[] rStack = new boolean[nV];

        for (int i = 0; i < nV; i++) {
            if (disc[i] == -1) {
                dfs(adj, i, low, disc, parent, rStack, -1, c, d);
            }
        }

        if (low[d] > disc[c] || low[c] > disc[d]) {
            return 1;
        }

        return 0;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] low, int[] disc, int[] parent, boolean[] rStack, int p, int c, int d) {
        low[i] = disc[i] = time;
        rStack[i] = true;

        time++;

        for (Integer e : adj.get(i)) {
            if (disc[e] == -1) {
                parent[e] = i;

                dfs(adj, e, low, disc, parent, rStack, i, c, d);

                low[i] = Math.min(low[i], low[e]);

            } else if (e != parent[i]) {
                low[i] = Math.min(low[i], disc[e]);
            }
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {
        adjList.get(source).add(destination);
    }
}
