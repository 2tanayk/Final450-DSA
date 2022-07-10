package graph;

import java.util.*;

public class LongestPathInDAG {

    static class Edge {
        int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        List<List<Edge>> adjList;

        int n;

        Graph() {
        }

        Graph(List<Edge> edges, int n) {
            adjList = new ArrayList<>();
            this.n = n;

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (Edge edge : edges) {
                adjList.get(edge.source).add(edge);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        List<Edge> edges = new ArrayList<>(nE);

        for (int i = 0; i < nE; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(src, dest, weight));
        }

        Graph graph = new Graph(edges, nV);

        int source = sc.nextInt();
        int destination = sc.nextInt();

        System.out.println(findLongestPathCost(graph, source, destination));
    }

    public static int findLongestPathCost(Graph graph, int src, int dest) {
        int[] dist = new int[graph.n];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        boolean vis[] = new boolean[graph.n];

        Stack<Integer> s = new Stack<>();


        for (int i = 0; i < graph.n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, s);
            }
        }

        while (!s.empty()) {
            int i = s.pop();

            if (dist[i] != Integer.MIN_VALUE) {
                for (Edge e : graph.adjList.get(i)) {
                    if (dist[i] + e.weight > dist[e.dest]) {
                        dist[e.dest] = dist[i] + e.weight;
                    }
                }
            }
        }

        return dist[dest];
    }

    private static void dfs(Graph g, int i, boolean[] vis, Stack<Integer> s) {
        vis[i] = true;

        for (Edge e : g.adjList.get(i)) {
            if (!vis[e.dest]) {
                dfs(g, e.dest, vis, s);
            }
        }

        s.push(i);
    }
}
