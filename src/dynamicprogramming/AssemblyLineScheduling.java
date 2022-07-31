package dynamicprogramming;

import java.util.*;

public class AssemblyLineScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] t = new int[2][n];
        int[][] s = new int[2][n];

        for (int i = 0; i < n; i++) {
            t[0][i] = sc.nextInt();
            t[1][i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            s[0][i] = sc.nextInt();
            s[1][i] = sc.nextInt();
        }

        int[] entry = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < 2; i++) {
            entry[i] = sc.nextInt();
            exit[i] = sc.nextInt();
        }

        System.out.println(carAssembly(n, t, s, entry, exit));
    }

    private static int carAssembly(int n, int[][] t, int[][] s, int[] entry, int[] exit) {
        t[0][0] += entry[0];
        t[1][0] += entry[1];


        t[0][n - 1] += exit[0];
        t[1][n - 1] += exit[1];

        for (int j = n - 2; j >= 0; j--) {
            t[0][j] += Math.min(t[0][j + 1], s[0][j + 1] + t[1][j + 1]);
            t[1][j] += Math.min(t[1][j + 1], s[1][j + 1] + t[0][j + 1]);
        }

        return Math.min(t[0][0], t[1][0]);
    }
}
