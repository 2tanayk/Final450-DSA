package searchingandsorting;

import java.util.*;

public class BishuAndSoldiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];


        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
//        int[] pre = new int[n];
//        pre[0] = p[0];
//
//        for (int i = 1; i < n; i++) {
//            pre[i] = pre[i - 1] + p[i];
//        }

        int q = sc.nextInt();

        while (q-- > 0) {
            int power = sc.nextInt();
            int[] ans = results(p, n, power);

            for (int e : ans) {
                System.out.print(e + " ");
            }

            System.out.println();
        }

    }

    private static int[] results(int[] arr, int n, int bp) {
        int ct = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= bp) {
                ct++;
                sum += arr[i];
            }
        }

//        int l = 0, h = n - 1, lPos = -1, mid = -1;
//
//        while (l <= h) {
//            mid = (l + h) / 2;
//
//            if (arr[mid] == bp) {
//                lPos = mid;
//                l = mid + 1;
//            } else if (arr[mid] < bp) {
//                l = mid + 1;
//            } else {
//                h = mid - 1;
//            }
//        }
//
//        if (lPos == -1) {
//            lPos = arr[mid] > bp ? mid : mid + 1;
//        } else {
//            lPos++;
//        }
//
//        if (lPos == 0) {
//            return new int[]{0, 0};
//        }
//
//        return new int[]{lPos, pre[lPos - 1]};

        return new int[]{ct, sum};
    }
}
