package searchingandsorting;

import java.util.*;

public class SortBySetBitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sortBySetBitCount(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    private static void sortBySetBitCount(Integer[] arr, int n) {
        Arrays.sort(arr, (o1, o2) -> Integer.bitCount(o2) - Integer.bitCount(o1));
    }
}
