package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        ArrayList<Long> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextLong());
        }
        int m = sc.nextInt();

        System.out.println(minDifferenceBetweenChocolates(arrayList, n, m));
    }

    private static long minDifferenceBetweenChocolates(ArrayList<Long> aList, long n, long m) {
        long minDiff;
        Collections.sort(aList);
        minDiff = aList.get((int) (m - 1)) - aList.get(0);

        for (int i = 0; i + (m - 1) < n; i++) {
            minDiff = Math.min(minDiff, aList.get((int) (i + (m - 1))) - aList.get(i));
        }
        return minDiff;
    }
}
