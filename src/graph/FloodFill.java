package graph;

import java.util.*;

public class FloodFill {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();


        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();

        int color = sc.nextInt();

        System.out.println(Arrays.deepToString(floodFill(arr, r, c, color)));
    }

    public static int[][] floodFill(int[][] arr, int r, int c, int color) {
        int m = arr.length;
        int n = arr[0].length;
        int oldColor = arr[r][c];

        if (oldColor == color) {
            return arr;
        }

        boolean[][] vis = new boolean[m][n];

        int[][] ops = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(r, c));

        while (!st.empty()) {
            Pair cur = st.pop();

            int xi = cur.x;
            int yi = cur.y;

            if (vis[xi][yi]) {
                continue;
            }

            vis[xi][yi] = true;


            for (int i = 0; i < 4; i++) {
                int xf = xi + ops[i][0];
                int yf = yi + ops[i][1];

                if (xf < 0 || xf > m - 1 || yf < 0 || yf > n - 1 || vis[xf][yf]) {
                    continue;
                }

                if (arr[xf][yf] == oldColor) {
                    st.push(new Pair(xf, yf));
                }
            }

            arr[xi][yi] = color;
        }


        return arr;
    }
}
