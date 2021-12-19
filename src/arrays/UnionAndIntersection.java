package arrays;

import java.util.HashSet;
import java.util.Scanner;

public class UnionAndIntersection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];

        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        printArrayUnion(arr1, m, arr2, n);
        printArrayIntersection(arr1, m, arr2, n);
    }

    private static void printArrayIntersection(int[] arr1, int m, int[] arr2, int n) {
        HashSet<Integer> set = new HashSet<>();

        int[] arr = Math.min(m, n) == m ? arr1 : arr2;

        for (int e : arr) {
            set.add(e);
        }

        arr = Math.max(m, n) == m ? arr1 : arr2;

        for (Integer e : arr) {
            if (set.contains(e)) {
                System.out.print(e + " ");
                set.remove(e);
            }
        }
    }

    private static void printArrayUnion(int[] arr1, int m, int[] arr2, int n) {
        HashSet<Integer> unionSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            unionSet.add(arr1[i]);
        }

        for (int i = 0; i < n; i++) {
            unionSet.add(arr2[i]);
        }

        for (Integer e : unionSet) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
