package greedy;

import java.util.*;

public class MinSumOfAbsoluteDifferenceTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }


        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println(findMinSum(arr1, arr2, n));
    }

    private static long findMinSum(int[] arr1, int[] arr2, int n) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Math.abs(arr1[i] - arr2[i]);
        }

        return sum;
    }
}
