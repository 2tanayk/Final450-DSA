package graph;

import java.util.*;

public class MinOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int connections = sc.nextInt();

        int[][] arr = new int[connections][2];

        for (int i = 0; i < connections; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(makeConnected(n, arr));
    }

    public static int makeConnected(int n, int[][] arr) {
        if (arr.length < n - 1) {
            return -1;
        }

        int m = arr.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(arr[i][0]).add(arr[i][1]);
            adj.get(arr[i][1]).add(arr[i][0]);
        }

        int ct = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ct++;
                dfs(adj, i, vis);
            }
        }

        return ct - 1;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int cur, boolean[] vis) {
        vis[cur] = true;

        for (int e : adj.get(cur)) {
            if (!vis[e]) {
                dfs(adj, e, vis);
            }
        }
    }
}
