package greedy;

import java.util.*;

public class MaximizeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println(maximize(arr, n));
    }

    private static int maximize(int[] arr, int n) {
        long m = 1000000007;
        Arrays.sort(arr);
        long sum = 0;

        for (long i = 0; i < n; i++) {
            sum += ((arr[(int) i] * i) % m);
            sum = sum % m;
        }

        return (int) sum;
    }
}
