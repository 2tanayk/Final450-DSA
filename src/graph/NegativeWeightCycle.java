package graph;

import java.util.*;

public class NegativeWeightCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        int[][] edges = new int[nE][3];


        for (int i = 0; i < nE; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();

            edges[i] = new int[]{src, dest, wt};
        }

        System.out.println(isNegativeWeightCycle(nV, edges));
    }

    public static int isNegativeWeightCycle(int nV, int[][] edges) {
        int nE = edges.length;

        int[] values = new int[nV];

        Arrays.fill(values, Integer.MAX_VALUE);

        int start = 0;

        values[start] = 0;


        int ct = nV - 1;

        boolean flag;

        while (ct-- > 0) {
            flag = false;

            for (int i = 0; i < nE; i++) {
                int src = edges[i][0];
                int dest = edges[i][1];
                int wt = edges[i][2];

                if (values[src] != Integer.MAX_VALUE && values[src] + wt < values[dest]) {
                    values[dest] = values[src] + wt;
                    flag = true;
                }
            }

            if (!flag) {
                return 0;
            }
        }


        for (int i = 0; i < nE; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];

            if (values[src] != Integer.MAX_VALUE && values[src] + wt < values[dest]) {
                return 1;
            }
        }

        return 0;
    }
}
