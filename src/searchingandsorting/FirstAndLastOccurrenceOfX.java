package searchingandsorting;

import java.util.*;

public class FirstAndLastOccurrenceOfX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(firstAndLast(arr, n, x));
    }

    private static ArrayList<Long> firstAndLast(long[] arr, int n, int x) {
        ArrayList<Long> ans = new ArrayList<>();

        if (arr.length == 1) {
            ans.add((long) 0);
            ans.add((long) 0);
            return ans;
        }

        int low = 0, high = arr.length - 1;
        long fPos = -1, lPos = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                fPos = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            }

            if (low == high) {
                if (arr[low] == x) {
                    fPos = low;
                }
                break;
            }
        }

        low = (int) (fPos + 1);
        high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                lPos = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            }

            if (low == high) {
                if (arr[low] == x) {
                    lPos = low;
                }
                break;
            }
        }

        ans.add(fPos);
        if (lPos == -1 && fPos != -1) {
            lPos = fPos;
        }
        ans.add(lPos);
        return ans;
    }
}
