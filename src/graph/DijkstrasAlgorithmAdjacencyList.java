package graph;

import java.util.*;

public class DijkstrasAlgorithmAdjacencyList {
    static class Node {
        int vertex, value;

        Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>(nV);

        for (int i = 0; i < nV; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= nE; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();

            int weight = sc.nextInt();

            addEdge(adjList, source, destination, weight);
        }

        int src = sc.nextInt();

        System.out.println(Arrays.toString(dijkstra(nV, adjList, src)));
    }

    static int[] dijkstra(int nV, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int[] dist = new int[nV];

        for (int i = 0; i < nV; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        PriorityQueue<Node> minQ = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);

        minQ.add(new Node(src, 0));

        while (!minQ.isEmpty()) {
            Node cur = minQ.poll();

            for (ArrayList<Integer> ls : adj.get(cur.vertex)) {
                int vertex = ls.get(0);
                int val = ls.get(1);
                if (dist[cur.vertex] + val < dist[vertex]) {
                    dist[vertex] = dist[cur.vertex] + val;
                    minQ.add(new Node(vertex, dist[vertex]));
                }
            }
        }

        return dist;
    }

    private static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adjList, int source, int destination, int weight) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(destination);
        temp.add(weight);

        adjList.get(source).add(temp);

        temp = new ArrayList<>();
        temp.add(source);
        temp.add(weight);

        adjList.get(destination).add(temp);
    }
}
