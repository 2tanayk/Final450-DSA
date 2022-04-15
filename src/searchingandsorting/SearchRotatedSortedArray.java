package searchingandsorting;

import java.util.*;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(searchSortedArray(arr, target));
    }

    private static int searchSortedArray(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[low] <= arr[mid]) {
                if (target <= arr[mid] && target >= arr[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] <= arr[high]) {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
