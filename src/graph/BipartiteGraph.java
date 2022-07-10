package graph;

import java.util.*;

public class BipartiteGraph {
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

        System.out.println(isBipartite(nV, adjList));
    }

    public static boolean isBipartite(int nV, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[nV];
        Arrays.fill(vis, -1);

        for (int i = 0; i < nV; i++) {
            if (vis[i] == -1) {
                if (dfs(adj, i, vis, -1, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] vis, int parent, int col) {
        vis[i] = col;

        for (Integer e : adj.get(i)) {
            if (vis[e] == -1) {
                if (dfs(adj, e, vis, i, 3 - col)) {
                    return true;
                }
            } else if (vis[e] == col) {
                return true;
            }
        }

        return false;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }
}
