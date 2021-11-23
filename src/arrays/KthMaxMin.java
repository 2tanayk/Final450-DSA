package arrays;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class KthMaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int kmax = Integer.MAX_VALUE, kmin = Integer.MIN_VALUE;
        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            sortedSet.add(sc.nextInt());
        }

        Iterator<Integer> setItr = sortedSet.iterator();

        for (int i = 1; setItr.hasNext(); i++) {
            Integer val = setItr.next();
            if (i == k) {
                kmin = val;
            }
            if (i == n - k + 1) {
                kmax = val;
            }
        }

        System.out.println(kmax);
        System.out.println(kmin);
    }
}

