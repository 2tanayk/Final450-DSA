package greedy;

import java.util.*;

public class MinimizeTheCashFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            arr = minCashFlow(arr, n);

            for (int[] p : arr) {
                System.out.println(Arrays.toString(p));
            }

            t--;
        }
    }

    private static int[][] minCashFlow(int[][] arr, int n) {
        int[] net = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                net[i] += arr[j][i];
                net[i] -= arr[i][j];
            }
        }

        arr = new int[n][n];


        while (true) {
            int minI = getMin(net);
            int maxI = getMax(net);
            int min = net[minI];
            int max = net[maxI];

            if (min == 0 && max == 0) {
                break;
            }

            int s = max + min;

            if (s < 0) {
                net[minI] = s;
                net[maxI] = 0;
                arr[minI][maxI] = max;
            } else if (s > 0) {
                net[maxI] = s;
                net[minI] = 0;
                arr[minI][maxI] = Math.abs(min);
            } else {
                net[minI] = 0;
                net[maxI] = 0;
                arr[minI][maxI] = max;
            }
        }

        return arr;
    }

    private static int getMax(int[] arr) {
        int n = arr.length;
        int maxI = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxI]) {
                maxI = i;
            }
        }

        return maxI;
    }

    private static int getMin(int[] arr) {
        int n = arr.length;
        int minI = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[minI]) {
                minI = i;
            }
        }

        return minI;
    }
}
