package array;

import java.util.HashSet;
import java.util.Scanner;

public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n1 = sc.nextInt();
        long[] arr1 = new long[(int) n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextLong();
        }

        long n2 = sc.nextInt();
        long[] arr2 = new long[(int) n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextLong();
        }

        System.out.println(isSubarray(arr1, n1, arr2, n2));
    }

    private static String isSubarray(long[] arr1, long n1, long[] arr2, long n2) {
        HashSet<Long> hashSet = new HashSet<>();
        for (long e : arr1) {
            hashSet.add(e);
        }

        for (long e : arr2) {
            if (!hashSet.contains(e)) {
                return "No";
            }
        }
        return "Yes";
    }
}
