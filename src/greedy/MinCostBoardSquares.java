package greedy;

import java.util.*;

public class MinCostBoardSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] x = new int[m];
        int[] y = new int[n];

        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
        }

        System.out.println(minimumCostOfBreaking(x, y, m, n));
    }

    public static int minimumCostOfBreaking(int[] x, int[] y, int m, int n) {
        Arrays.sort(x);
        Arrays.sort(y);

        for (int i = 0; i < x.length / 2; i++) {
            int temp = x[i];
            x[i] = x[x.length - i - 1];
            x[x.length - i - 1] = temp;
        }

        for (int i = 0; i < y.length / 2; i++) {
            int temp = y[i];
            y[i] = y[y.length - i - 1];
            y[y.length - i - 1] = temp;
        }

        m = x.length;
        n = y.length;

        int i = 0, j = 0, hpc = 1, vpc = 1;
        int tot = 0;

        while (i < m || j < n) {
            if (i < m && j < n) {
                if (x[i] >= y[j]) {
                    tot += (x[i] * vpc);
                    hpc++;
                    i++;
                } else {
                    tot += (y[j] * hpc);
                    vpc++;
                    j++;
                }
            } else if (i < m) {
                tot += (x[i] * vpc);
                i++;
            } else {
                tot += (y[j] * hpc);
                j++;
            }
        }

        return tot;
    }
}
