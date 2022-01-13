package arrays;

import java.util.*;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(longestConsecutiveSubsequence(arr, n));
    }

    private static int longestConsecutiveSubsequence(int[] arr, int n) {
        if (n == 1) {
            return 1;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        arr = removeDuplicates(arr, n);
        n = arr.length;

        int longest = 0;

        for (int e : arr) {
            hashSet.add(e);
        }

        for (int i = 0; i < n; i++) {
            if (!hashSet.contains(arr[i] - 1)) {
                int currentNo = arr[i];
                int currentLongest = 1;

                while (hashSet.contains(currentNo + 1)) {
                    currentLongest++;
                    currentNo++;
                }
                longest = Math.max(longest, currentLongest);
            }
        }


        return longest;
    }

    private static int[] removeDuplicates(int[] arr, int n) {
        HashSet<Integer> hs = new HashSet<>();
        int[] uArr;
        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }
        System.out.println(hs);
        uArr = new int[hs.size()];
        int i = 0;
        for (Integer e : hs) {
            uArr[i++] = e;
        }
        return uArr;
    }

}
