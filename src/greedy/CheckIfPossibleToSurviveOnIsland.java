package greedy;

import java.util.*;

public class CheckIfPossibleToSurviveOnIsland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s, n, m;
        s = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        System.out.println(minimumDays(s, n, m));
    }

    private static int minimumDays(int s, int n, int m) {
        if (n < m) {
            return -1;
        }

        int tot = s - s / 7;
        int req = s * m;

        if (req > tot * n) {
            return -1;
        }

        return (int) Math.ceil(req * 1.0 / n);
    }
}
