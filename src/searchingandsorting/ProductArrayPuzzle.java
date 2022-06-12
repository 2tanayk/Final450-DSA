package searchingandsorting;

import java.util.*;

public class ProductArrayPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(productExceptSelf(arr, n)));
    }

    private static long[] productExceptSelf(int[] arr, int n) {
        int ct = 0, pos = -1;
        long prod = 1;

        long[] ans = new long[n];


        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                ct++;
                pos = i;
                continue;
            }

            prod *= arr[i];
        }

        if (ct > 1) {
            return ans;
        }

        if (ct == 1) {
            ans[pos] = prod;

            return ans;
        }

        for (int i = 0; i < n; i++) {
            ans[i] = prod / arr[i];
        }

        return ans;
    }
}
