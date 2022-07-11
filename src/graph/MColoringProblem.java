package graph;

import java.util.*;

public class MColoringProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();

        boolean[][] graph = new boolean[nV][nV];

        int nE = sc.nextInt();

        for (int i = 0; i < nE; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src][dest] = true;
            graph[dest][src] = true;
        }

        int m = sc.nextInt();

        System.out.println(graphColoring(graph, m, nV));
    }

    public static boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] col = new int[n];
        Arrays.fill(col, -1);

        return isMColorPossible(graph, 0, col, m, n);
    }

    private static boolean isMColorPossible(boolean[][] graph, int cur, int[] col, int m, int n) {
        if (cur == n) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (!isColorValid(graph, cur, i, col)) {
                continue;
            }

            col[cur] = i;

            if (isMColorPossible(graph, cur + 1, col, m, n)) {
                return true;
            }

            col[cur] = -1;
        }

        return false;
    }

    private static boolean isColorValid(boolean[][] graph, int cur, int color, int[] col) {
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            if (!graph[cur][i]) {
                continue;
            }

            if (color == col[i]) {
                return false;
            }
        }

        return true;
    }
}
