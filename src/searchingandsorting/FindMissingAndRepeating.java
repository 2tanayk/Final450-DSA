package searchingandsorting;

import java.util.*;

public class FindMissingAndRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(findTwoElement(arr, n)));
    }

    private static int[] findTwoElement(int[] arr, int n) {
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                ans[0] = Math.abs(arr[i]);
            } else {
                arr[Math.abs(arr[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }
}
