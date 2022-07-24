package bitmanipulation;

import java.util.*;

public class DivideTwoIntegersUsingBitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(divide(x, y));
    }

    public static long divide(long a, long b) {
        if (b == 0) {
            return Long.MAX_VALUE;
        }

        if (a == 0) {
            return 0;
        }

        boolean sign = a < 0 && b > 0 || a > 0 && b < 0;

        a = Math.abs(a);
        b = Math.abs(b);

        long q = 0, temp = 0;

        for (int i = 31; i >= 0; i--) {
            if (temp + (b << i) <= a) {
                temp += b << i;
                q += 1 << i;
            }
        }

        return sign ? -q : q;
    }
}
