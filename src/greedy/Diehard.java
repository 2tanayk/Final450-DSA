package greedy;

import java.util.*;

class Diehard {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int h, a;
            h = sc.nextInt();
            a = sc.nextInt();

            System.out.println(maxSurvivalTime(h, a));
        }
    }


    private static int maxSurvivalTime(int h, int a) {
        int time = 1;

        h += 3;
        a += 2;

        while (true) {
            if (h > 5 && a > 10) {
                h -= 2;
                a -= 8;
                time += 2;
            } else if (h > 20 && a <= 10) {
                h = h - 17;
                a = a + 7;
                time += 2;
            } else {
                return time;
            }
        }
    }
}