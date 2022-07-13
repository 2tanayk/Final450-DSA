package tree;

import java.util.*;

public class MinSwapsToConvertBinaryTreeToBST {
    static int i;

    static class Pair {
        int num, pos;

        Pair(int num, int pos) {
            this.num = num;
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

        System.out.println(minSwaps(n, arr));
    }

    public static int minSwaps(int n, int[] arr) {
        i = 0;
        Pair in[] = new Pair[n];

        inorderTraversal(arr, in, 0, n);

        Pair cpy[] = new Pair[n];

        for (int i = 0; i < n; i++) {
            cpy[i] = new Pair(in[i].num, in[i].pos);
        }

        Arrays.sort(in, (p1, p2) -> p1.num - p2.num);

        int swaps = 0;

        for (int i = 0; i < n; ) {
            int sI = in[i].pos;

            if (sI != i) {
                Pair temp = in[i];
                in[i] = in[sI];
                in[sI] = temp;

                swaps++;
            } else {
                i++;
            }
        }

        return swaps;
    }


    private static void inorderTraversal(int[] arr, Pair[] in, int index, int n) {
        if (index >= n) {
            return;
        }

        inorderTraversal(arr, in, 2 * index + 1, n);
        in[i] = new Pair(arr[index], i++);
        inorderTraversal(arr, in, 2 * index + 2, n);
    }
}
