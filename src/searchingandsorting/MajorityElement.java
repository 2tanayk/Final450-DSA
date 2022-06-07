package searchingandsorting;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(majorityElement(arr, n));
    }

    private static int majorityElement(int[] arr, int n) {
        int cur = arr[0], ct = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == cur) {
                ct++;
            } else {
                ct--;
            }

            if (ct == 0) {
                cur = arr[i];
                ct = 1;
            }
        }

        ct = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == cur) {
                ct++;
            }

            if (ct > n / 2) {
                return cur;
            }
        }

        return -1;
    }
}
