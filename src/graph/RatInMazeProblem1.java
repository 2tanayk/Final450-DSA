package graph;

import java.util.*;

public class RatInMazeProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(findPath(arr, n));
    }

    public static ArrayList<String> findPath(int[][] arr, int n) {
        ArrayList<String> paths = new ArrayList<>();

        if (arr[0][0] == 0 || arr[n - 1][n - 1] == 0) {
            return paths;
        }

        boolean[][] visited = new boolean[n][n];

        searchPaths(arr, n, 0, 0, visited, "", paths);

        return paths;
    }

    private static void searchPaths(int[][] arr, int n, int ri, int ci, boolean[][] v, String cur, ArrayList<String> paths) {
        if (ri == n - 1 && ci == n - 1) {
            paths.add(cur);
            return;
        }

        if (ri < 0 || ri > n - 1 || ci < 0 || ci > n - 1) {
            return;
        }

        if (arr[ri][ci] == 0) {
            return;
        }

        if (v[ri][ci]) {
            return;
        }


        v[ri][ci] = true;

        searchPaths(arr, n, ri + 1, ci, v, cur + "D", paths);
        searchPaths(arr, n, ri, ci - 1, v, cur + "L", paths);
        searchPaths(arr, n, ri, ci + 1, v, cur + "R", paths);
        searchPaths(arr, n, ri - 1, ci, v, cur + "U", paths);

        v[ri][ci] = false;

    }
}
