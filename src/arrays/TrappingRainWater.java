package arrays;

import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(amountOfWaterTrapped(arr, n));
    }

    private static long amountOfWaterTrapped(int[] arr, int n) {
        long water = 0;
        int[] lHeightArr = new int[n];
        int[] rHeightArr = new int[n];

        lHeightArr[0] = arr[0];
        rHeightArr[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            lHeightArr[i] = Math.max(lHeightArr[i - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rHeightArr[i] = Math.max(rHeightArr[i + 1], arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            water += Math.min(lHeightArr[i], rHeightArr[i]) - arr[i];
        }
        return water;
    }

}
