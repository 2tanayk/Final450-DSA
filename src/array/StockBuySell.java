package array;

import java.util.Scanner;

public class StockBuySell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(calculateMaxProfit(arr, n));
    }

    private static int calculateMaxProfit(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] - min > maxProfit) {
                maxProfit = arr[i] - min;
            }
        }
        return maxProfit;
    }
}