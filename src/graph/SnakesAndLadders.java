package graph;

import java.util.*;

public class SnakesAndLadders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] arr) {
        int n = arr.length;

        HashSet<Integer> vSet = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cell = cur[0];
            int moves = cur[1];

            for (int i = 1; i <= 6; i++) {
                int next = cell + i;

                int[] cord = cellToPos(next, n);
                int x = cord[0];
                int y = cord[1];

                if (arr[x][y] != -1) {
                    next = arr[x][y];
                }

                if (next == n * n) {
                    return moves + 1;
                }

                if (!vSet.contains(next)) {
                    vSet.add(next);
                    q.add(new int[]{next, moves + 1});
                }
            }
        }

        return -1;
    }

    private static int[] cellToPos(int num, int n) {
        int r, c;

        if (num % n == 0) {
            r = n - num / n;

            if (n % 2 == 0) {
                c = r % 2 == 0 ? 0 : n - 1;
            } else {
                c = r % 2 == 0 ? n - 1 : 0;
            }
        } else {
            r = n - num / n - 1;

            if (n % 2 == 0) {
                c = r % 2 == 0 ? n - num % n : num % n - 1;
            } else {
                c = r % 2 == 0 ? num % n - 1 : n - num % n;
            }
        }

        return new int[]{r, c};
    }
}
