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

    private static int[] dijkstra(int nV, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int[] dist = new int[nV];
        boolean[] vis = new boolean[nV];
        //helps calculate the path, not relevant to this question on GFG
        int[] prev = new int[nV];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        dist[src] = 0;

        PriorityQueue<Node> minQ = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);

        minQ.add(new Node(src, 0));

        while (!minQ.isEmpty()) {
            Node cur = minQ.poll();
            int curDist = cur.value;
            int curNode = cur.vertex;

            if (vis[curNode]) {
                continue;
            }

            vis[curNode] = true;

            for (ArrayList<Integer> ls : adj.get(curNode)) {
                int nextNode = ls.get(0);
                int weight = ls.get(1);

                int nextDist = curDist + weight;

                if (!vis[nextNode] && nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    prev[nextNode] = curNode;
                    minQ.add(new Node(nextNode, nextDist));
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
