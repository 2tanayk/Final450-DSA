package graph;

import java.util.*;

public class DFSUndirectedConnected {
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

        System.out.println(dfs(nV, adjacencyList));
    }

    private static ArrayList<Integer> dfs(int nV, ArrayList<ArrayList<Integer>> adjList) {
        int source = 0;
        boolean[] visited = new boolean[nV];
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> dfsList = new ArrayList<>();

        s.push(source);

        while (!s.isEmpty()) {
            int cur = s.pop();

            if (!visited[cur]) {
                dfsList.add(cur);
                visited[cur] = true;
            }

            ArrayList<Integer> curList = adjList.get(cur);

            for (int i = curList.size() - 1; i >= 0; i--) {
                int neighbouringNode = curList.get(i);
                if (!visited[neighbouringNode]) {
                    s.push(neighbouringNode);
                }
            }
        }

        return dfsList;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
}
