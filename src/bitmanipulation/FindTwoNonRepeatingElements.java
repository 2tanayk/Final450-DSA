package bitmanipulation;

import java.util.*;

public class FindTwoNonRepeatingElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    public static int[] singleNumber(int[] arr) {
        int n = arr.length;

        int xor = arr[0];

        for (int i = 1; i < n; i++) {
            xor ^= arr[i];
        }

        int r = xor & ~(xor - 1);

        int a = 0, b = 0;

        for (int i = 0; i < n; i++) {
            if ((arr[i] & r) > 0) {
                a ^= arr[i];
            } else {
                b ^= arr[i];
            }
        }

        int[] ans = {a, b};

        Arrays.sort(ans);

        return ans;
    }
}
