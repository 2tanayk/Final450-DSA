package graph;

import java.util.*;

public class NumberOfTrianglesInGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();

        int[][] graph = new int[nV][nV];

        for (int i = 0; i < nV; i++) {
            for (int j = 0; j < nV; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean isDirected = sc.nextInt() == 1;

        System.out.println(countTriangles(graph, nV, isDirected));
    }

    private static int countTriangles(int[][] graph, int nV, boolean isDirected) {
        int ct = 0;

        for (int i = 0; i < nV; i++) {
            for (int j = 0; j < nV; j++) {
                for (int k = 0; k < nV; k++) {
                    if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1) {
                        ct++;
                    }
                }
            }
        }

        return isDirected ? ct / 3 : ct / 6;
    }
}
