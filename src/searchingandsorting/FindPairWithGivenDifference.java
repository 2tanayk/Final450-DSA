package searchingandsorting;

import java.util.*;

public class FindPairWithGivenDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(findPair(arr, size, n));
    }

    private static boolean findPair(int[] arr, int size, int n) {
        Arrays.sort(arr);

        for (int i = 0; i < size; i++) {
            int index = Arrays.binarySearch(arr, arr[i] + n);
            if (index >= 0 && index != i) {
                return true;
            }
        }

        return false;
    }
}
