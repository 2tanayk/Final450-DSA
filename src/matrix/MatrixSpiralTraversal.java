package matrix;

import java.util.*;

public class MatrixSpiralTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(spiralTraversal(arr, r, c));
    }

    private static ArrayList<Integer> spiralTraversal(int[][] arr, int r, int c) {
        ArrayList<Integer> spiralList = new ArrayList<>();
        int left = 0, right = c - 1, top = 0, bottom = r - 1;
        int ctE = 0, total = r * c;

        while (ctE < total) {
            for (int i = left; i <= right; i++) {
                spiralList.add(arr[top][i]);
                ctE++;
                if (ctE >= total) {
                    return spiralList;
                }
            }

            if ((top + 1) < r) {
                top++;
            }

            for (int i = top; i <= bottom; i++) {
                spiralList.add(arr[i][right]);
                ctE++;
                if (ctE >= total) {
                    return spiralList;
                }
            }

            if ((right - 1) >= 0) {
                right--;
            }

            for (int i = right; i >= left; i--) {
                spiralList.add(arr[bottom][i]);
                ctE++;
                if (ctE >= total) {
                    return spiralList;
                }
            }

            if ((bottom - 1) >= 0) {
                bottom--;
            }

            for (int i = bottom; i >= top; i--) {
                spiralList.add(arr[i][left]);
                ctE++;
                if (ctE >= total) {
                    return spiralList;
                }
            }

            if ((left + 1) < c) {
                left++;
            }
        }
        return spiralList;
    }
}
