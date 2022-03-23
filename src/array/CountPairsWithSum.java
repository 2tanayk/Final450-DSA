package array;

import java.util.HashMap;
import java.util.Scanner;

public class CountPairsWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(calculatePairsWithSum(arr, n, k));
    }

    private static int calculatePairsWithSum(int[] arr, int n, int k) {
        int totalPairs = 0;
        HashMap<Integer, Integer> arrHashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = k - arr[i];
            if (arrHashMap.containsKey(diff)) {
                totalPairs += arrHashMap.get(diff);
            }
            arrHashMap.put(arr[i], arrHashMap.getOrDefault(arr[i], 0) + 1);
        }
        return totalPairs;
    }
}
