package greedy;

import java.util.*;

public class SmallestNumberGivenDigitsAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(smallestNumber(s, d));
    }

    private static String smallestNumber(int s, int d) {
        if (9 * d < s) {
            return "-1";
        }

        if (d == 1) {
            return "" + s;
        }

        StringBuilder ans = new StringBuilder();

        int p = Math.max(s - (d - 1) * 9, 1);
        ans.append(p);

        s -= p;
        d--;

        while (d > 1) {
            p = Math.max(s - (d - 1) * 9, 0);

            ans.append(p);

            s -= p;
            d--;
        }

        ans.append(s);

        return ans.toString();
    }
}
