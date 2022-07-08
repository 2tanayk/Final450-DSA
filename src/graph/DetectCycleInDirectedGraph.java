package graph;

import java.util.*;

public class DetectCycleInDirectedGraph {
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

        System.out.println(directedGraphHasCycle(adjacencyList, nV));
    }

    private static boolean directedGraphHasCycle(ArrayList<ArrayList<Integer>> graph, int nV) {
        boolean[] visited = new boolean[nV];
        boolean[] recursionStack = new boolean[nV];
        
        for (int i = 0; i < nV; i++) {

            if (!visited[i]) {
                if (dfs(graph, i, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] vis, boolean[] rStack) {
        vis[v] = true;
        rStack[v] = true;

        for (int adjacent : graph.get(v)) {
            if (!vis[adjacent]) {
                if (dfs(graph, adjacent, vis, rStack)) {
                    return true;
                }
            } else if (rStack[adjacent]) {
                return true;
            }
        }

        rStack[v] = false;

        return false;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
    }
}
