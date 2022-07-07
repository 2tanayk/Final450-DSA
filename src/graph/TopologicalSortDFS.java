package graph;

import java.util.*;

public class TopologicalSortDFS {
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

        System.out.println(Arrays.toString(topoSort(nV, adjList)));
    }

    private static int[] topoSort(int nV, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[nV];
        int[] ans = new int[nV];

        Stack<Integer> tStack = new Stack<>();

        for (int i = 0; i < nV; i++) {
            if (!vis[i]) {
                topoDFS(adj, i, vis, tStack);
            }
        }

        int i = 0;
        while (!tStack.empty()) {
            ans[i++] = tStack.pop();
        }

        return ans;
    }

    private static void topoDFS(ArrayList<ArrayList<Integer>> adj, int cur, boolean[] vis, Stack<Integer> s) {
        vis[cur] = true;

        for (Integer e : adj.get(cur)) {
            if (!vis[e]) {
                topoDFS(adj, e, vis, s);
            }
        }

        s.push(cur);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }
}
