package greedy;

import java.util.*;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.set(i, sc.nextInt());
        }

        int m = sc.nextInt();

        System.out.println(findMinDiff(arr, n, m));
    }

    private static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        if (n == 1) {
            return (long) a.get(0);
        }

        if (n == 2 && m == 1) {
            return a.get(0) > a.get(1) ? (long) a.get(1) : (long) a.get(0);
        }

        if (n == 2 && m == 2) {
            return (long) Math.abs(a.get(0) - a.get(1));
        }

        Collections.sort(a);

        int i = 0, j = i + m - 1, min = Integer.MAX_VALUE;

        while (j < n) {
            min = Math.min(min, a.get(j) - a.get(i));
            i++;
            j++;
        }

        return (long) min;
    }
}
