package greedy;

import java.util.*;

public class ShopInCandyStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] costArr = new int[n];

        for (int i = 0; i < n; i++) {
            costArr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minAndMaxPrice(costArr, n, k));
    }

    private static ArrayList<Integer> minAndMaxPrice(int[] arr, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(arr);
        int cost = 0;
        int start = 0, end = n - 1;

        while (start <= end) {
            cost += arr[start];
            start++;
            end -= k;
        }

        ans.add(cost);

        cost = 0;
        start = 0;
        end = n - 1;

        while (start <= end) {
            cost += arr[end];
            end--;
            start += k;
        }

        ans.add(cost);

        return ans;
    }
}
