package arrays;

import java.util.HashSet;
import java.util.Scanner;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(isThereZeroSumSubarray(arr, n) ? "Yes" : "No");
    }

    private static boolean isThereZeroSumSubarray(int[] arr, int n) {
        HashSet<Integer> sumSet = new HashSet<>();
        int sum = 0;
        for (int e : arr) {
            sumSet.add(sum);
            sum += e;
            if (sumSet.contains(sum)) {
                return true;
            }
        }
        return false;
    }
}
