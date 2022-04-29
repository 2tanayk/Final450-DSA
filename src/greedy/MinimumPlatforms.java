package greedy;

import java.util.*;

public class MinimumPlatforms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arrivals = new int[n];
        int[] departures = new int[n];

        for (int i = 0; i < n; i++) {
            arrivals[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            departures[i] = sc.nextInt();
        }

        System.out.println(minPlatforms(arrivals, departures, n));
    }

    private static int minPlatforms(int[] arv, int[] dep, int n) {
        int max = 0, curP = 0;

        Arrays.sort(arv);
        Arrays.sort(dep);

        int aPtr = 0, dPtr = 0;

        while (aPtr < n && dPtr < n) {
            if (arv[aPtr] <= dep[dPtr]) {
                curP++;
                aPtr++;
            } else {
                curP--;
                dPtr++;
            }

            if (curP > max) {
                max = curP;
            }
        }


        return max;
    }
}
