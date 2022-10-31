package searchingandsorting;

import java.util.*;

public class SmallestFactorialNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(findNum(n));
    }

    static int findNum(int n) {
        int l = 0;
        int r = 5 * n;

        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (check(mid, n)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean check(int num, int n) {
        int ct = 0;

        int d = 5;

        while (d <= num) {
            ct += (num / d);
            d *= 5;
        }

        return ct >= n;
    }
}
