package dynamicprogramming;

import java.util.*;

public class PaintingTheFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(countWays(n, k));
    }

    private static long countWays(int n, int k) {
        if (n == 1) {
            return k;
        }

        long m = (long) Math.pow(10, 9) + 7;

        long same = k;
        long diff = (long) k * (k - 1) % m;
        long tot = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = (tot * (k - 1)) % m;
            tot = (same % m + diff % m) % m;
        }

        return tot;
    }
}
