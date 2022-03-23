package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        print2dArray(mergeOverlappingIntervals(arr, n));
    }

    private static int[][] mergeOverlappingIntervals(int[][] arr, int n) {
        Arrays.sort(arr, (o1, o2) -> o1 != o2 ? o1[0] - o2[0] : o1[1] - o2[1]);
        ArrayList<int[]> mArr = new ArrayList<>();

        int iStart = arr[0][0];
        int iEnd = arr[0][1];

        for (int i = 0; i < n - 1; i++) {
            if (iEnd >= arr[i + 1][0]) {
                iStart = Math.min(iStart, arr[i + 1][0]);
                iEnd = Math.max(iEnd, arr[i + 1][1]);
            } else {
                mArr.add(new int[]{iStart, iEnd});
                iStart = arr[i + 1][0];
                iEnd = arr[i + 1][1];
            }
        }

        mArr.add(new int[]{iStart, iEnd});

        int[][] fArr = new int[mArr.size()][2];
        int k = 0;
        for (int[] e : mArr) {
            fArr[k++] = e;
        }
        return fArr;
    }

    private static void print2dArray(int[][] arr) {
        System.out.print("[");
        for (int[] e : arr) {
            System.out.print(Arrays.toString(e));
        }
        System.out.print("]");
        System.out.println();
    }
}
