package searchingandsorting;

import java.util.*;

public class MinSwapsToSortArray {
    static class Pair {
        int no, pos;

        Pair(int no, int pos) {
            this.no = no;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minSwaps(arr));
    }

    private static int minSwaps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        Arrays.sort(pairs, Comparator.comparingInt(o -> o.no));

        int ct = 0;

        for (int i = 0; i < n; ) {
            Pair pair = pairs[i];

            if (pair.pos != i) {
                Pair temp = pairs[i];
                pairs[i] = pairs[pair.pos];
                pairs[pair.pos] = temp;

                ct++;
            } else {
                i++;
            }
        }

        return ct;
    }
}
