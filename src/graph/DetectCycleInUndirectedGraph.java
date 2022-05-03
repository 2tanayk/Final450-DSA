package graph;

import java.util.*;

public class DetectCycleInUndirectedGraph {
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

        System.out.println(graphHasCycle(adjacencyList, nV));
    }

    private static boolean graphHasCycle(ArrayList<ArrayList<Integer>> graph, int nV) {
        boolean[] visited = new boolean[nV];
        for (int i = 0; i < nV; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (int adjacent : graph.get(v)) {
            if (!visited[adjacent]) {
                if (dfs(graph, adjacent, visited, v)) {
                    return true;
                } else if (adjacent != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }
}
