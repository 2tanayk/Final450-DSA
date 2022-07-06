package graph;

import java.util.*;

public class StepsByKnight {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] kPos = new int[2];
        int[] tPos = new int[2];

        for (int i = 0; i < 2; i++) {
            kPos[i] = sc.nextInt();
        }

        for (int i = 0; i < 2; i++) {
            tPos[i] = sc.nextInt();
        }

        System.out.println(minStepToReachTarget(kPos, tPos, n));
    }

    public static int minStepToReachTarget(int[] kPos, int[] tPos, int n) {
        kPos[0]--;
        kPos[1]--;

        tPos[0]--;
        tPos[1]--;

        if (tPos[0] == kPos[0] && tPos[1] == kPos[1]) {
            return 0;
        }
        boolean[][] vis = new boolean[n][n];

        int steps = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(kPos[0], kPos[1]));
        vis[kPos[0]][kPos[1]] = true;

        while (!q.isEmpty()) {
            int ct = q.size();

            steps++;

            while (ct > 0) {
                Pair cur = q.poll();

                int ix = cur.x;
                int iy = cur.y;

                int[][] ops = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};

                for (int i = 0; i < 8; i++) {
                    int fx = ix + ops[i][0];
                    int fy = iy + ops[i][1];

                    if (fx < 0 || fx > n - 1 || fy < 0 || fy > n - 1 || vis[fx][fy]) {
                        continue;
                    }

                    if (fx == tPos[0] && fy == tPos[1]) {
                        return steps;
                    }

                    vis[fx][fy] = true;
                    q.add(new Pair(fx, fy));
                }

                ct--;
            }
        }

        return -1;
    }
}
