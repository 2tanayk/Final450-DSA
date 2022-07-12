package graph;

import java.util.*;

public class TwoCliqueProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < nV; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 1; i <= nE; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();

            addEdge(adjacencyList, source, destination);
        }

        System.out.println(canGraphBeDividedIntoTwoCliques(adjacencyList, nV));
    }

    private static boolean canGraphBeDividedIntoTwoCliques(ArrayList<ArrayList<Integer>> adj, int nV) {
        complementGraph(adj, nV);

        return isBipartite(adj, nV);
    }

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int nV) {
        int[] vis = new int[nV];
        Arrays.fill(vis, -1);

        for (int i = 0; i < nV; i++) {
            if (vis[i] == -1 && dfs(adj, i, vis, 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] vis, int col) {
        vis[i] = col;

        for (Integer e : adj.get(i)) {
            if (vis[e] == -1) {
                if (dfs(adj, e, vis, 3 - col)) {
                    return true;
                }
            } else if (vis[e] == col) {
                return true;
            }
        }

        return false;
    }

    private static void complementGraph(ArrayList<ArrayList<Integer>> adj, int nV) {
        for (int i = 0; i < nV; i++) {
            boolean[] adjacents = new boolean[nV];
            adjacents[i] = true;

            for (Integer e : adj.get(i)) {
                adjacents[e] = true;
            }

            ArrayList<Integer> compl = new ArrayList<>();

            for (int j = 0; j < nV; j++) {
                if (adjacents[j]) {
                    continue;
                }

                compl.add(j);
            }

            adj.set(i, compl);
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }
}
