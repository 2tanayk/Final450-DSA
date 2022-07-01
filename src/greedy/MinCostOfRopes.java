package greedy;

import java.util.*;

public class MinCostOfRopes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(minCost(arr, n));
    }

    private static long minCost(long[] arr, int n) {
        long ans = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {
            long r1 = pq.poll();

            if (pq.isEmpty()) {
                break;
            }

            long r2 = pq.poll();

            ans += r1 + r2;

            pq.add(r1 + r2);
        }

        return ans;
    }
}
