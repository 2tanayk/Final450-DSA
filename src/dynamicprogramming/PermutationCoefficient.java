package dynamicprogramming;

import java.util.*;

public class PermutationCoefficient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(nPr(n, r));
    }

    private static int nPr(int n, int r) {
        int p = 1;

        for (int i = 0; i < r; i++) {
            p *= (n - i);
        }

        return p;
    }
}
