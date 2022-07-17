package heap;

import java.util.*;

public class KthLargestSubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        int k = sc.nextInt();

        System.out.println(kthLargest(n, k, arr));
    }

    private static int kthLargest(int n, int k, int[] arr) {
        int[] pre = new int[n + 1];
        pre[0] = 0;
        pre[1] = arr[0];

        for (int i = 2; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = pre[j] - pre[i - 1];

                if (pq.size() < k) {
                    pq.add(sum);
                } else if (pq.peek() < sum) {
                    pq.poll();
                    pq.add(sum);
                }
            }
        }

        return pq.poll();
    }
}
