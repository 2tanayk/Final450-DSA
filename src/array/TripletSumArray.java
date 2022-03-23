package array;

import java.util.Arrays;
import java.util.Scanner;

public class TripletSumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        System.out.println(ifTripletWithSumXExists(arr, n, x) ? "Yes" : "No");
    }

    private static boolean ifTripletWithSumXExists(int[] arr, int n, int x) {
        Arrays.sort(arr);

        for (int i = 0; i <= n - 3; i++) {
            int sum = x - arr[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int current = arr[start] + arr[end];
                if (current == sum) {
                    return true;
                } else if (current > sum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return false;
    }
}
