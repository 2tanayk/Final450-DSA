package graphs;

import java.util.*;

public class BFSDirectedConnected {
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

        System.out.println(bfs(nV, adjacencyList));
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
}
