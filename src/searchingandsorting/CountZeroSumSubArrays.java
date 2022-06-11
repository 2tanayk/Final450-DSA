package searchingandsorting;

import java.util.*;

public class CountZeroSumSubArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(findSubArray(arr, n));
    }

    private static long findSubArray(long[] arr, int n) {
        int ct = 0;
        long sum = 0;
        long[] cf = new long[n];

        HashMap<Long, Integer> fm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                ct++;
            }

            if (fm.containsKey(sum)) {
                ct += fm.get(sum);
            }

            fm.put(sum, fm.getOrDefault(sum, 0) + 1);
        }

        return ct;
    }
}
