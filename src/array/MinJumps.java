package array;

import java.util.Scanner;

public class MinJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minJumps(arr, n));
    }

    private static int minJumps(int[] arr, int n) {
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        if (n == 1) {
            return 0;
        } else if (arr[0] == 0) {
            return 0;
        } else {
            for (int i = 1; i < n; i++) {
                if (i == n - 1) {
                    return jumps;
                }
                maxReach = Math.max(maxReach, arr[i] + i);
                steps--;
                if (steps < 0) {
                    return -1;
                }
                if (steps == 0) {
                    jumps++;
                    if (i >= maxReach) {
                        return -1;
                    }
                    steps = maxReach - i;
                }
            }
        }
        return jumps;
    }
}