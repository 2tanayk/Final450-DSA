package array;

import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i;

        for (int j = 0; j < n; j++) {
            arr[j] = sc.nextInt();
        }

        if (n % 2 == 0) {
            min = Math.min(arr[0], arr[1]);
            max = Math.max(arr[0], arr[1]);
            i = 2;
        } else {
            min = max = arr[0];
            i = 1;
        }

        while (i < n - 1) {
            int pairMin = Math.min(arr[i], arr[i + 1]);
            int pairMax = Math.max(arr[i], arr[i + 1]);
            max = Math.max(max, pairMax);
            min = Math.min(min, pairMin);
            i += 2;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
