package graphs;

import java.util.*;

public class BFSDirected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of vertices:");
        int nV = sc.nextInt();
        System.out.println("Enter no. of edges:");
        int nE = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(nV);

        for (int i = 0; i < nV; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 1; i <= nE; i++) {
            System.out.println("Enter source and destination vertices:");
            int source = sc.nextInt();
            int destination = sc.nextInt();

            addEdge(adjacencyList, source, destination);
        }

        bfs(nV, adjacencyList);
    }

    private static ArrayList<Integer> bfs(int nV, ArrayList<ArrayList<Integer>> adj) {
        int source = 0;
        boolean[] visited = new boolean[nV];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfsList = new ArrayList<>();

        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            bfsList.add(cur);

            for (Integer neighbouringNode : adj.get(cur)) {
                if (!visited[neighbouringNode]) {
                    q.add(neighbouringNode);
                    visited[neighbouringNode] = true;
                }
            }
        }
        return bfsList;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Adjacency List of " + i + " ");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print("->" + adjacencyList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
