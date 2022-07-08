package graph;

import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        boolean[][] vis = new boolean[n][m];
        int ct = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '0') {
                    continue;
                }

                if (!vis[i][j]) {
                    dfs(arr, i, j, vis);
                    ct++;
                }
            }
        }

        return ct;
    }

    private static void dfs(char[][] arr, int i, int j, boolean[][] vis) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] ops = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || vis[i][j] || arr[i][j] == '0') {
            return;
        }

        vis[i][j] = true;

        for (int k = 0; k < 8; k++) {
            dfs(arr, i + ops[k][0], j + ops[k][1], vis);
        }
    }
}
