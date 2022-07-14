package tree;

import java.util.*;

public class CheckTreeIsMirrorImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        int[] arr1 = new int[2 * e];
        int[] arr2 = new int[2 * e];

        System.out.println(checkMirrorTree(n, e, arr1, arr2));
    }

    private static int checkMirrorTree(int n, int e, int[] arr1, int[] arr2) {
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();

        for (int i = 0; i + 1 < arr1.length; i += 2) {
            int src = arr1[i];
            int dest = arr1[i + 1];

            if (!map.containsKey(src)) {
                Stack<Integer> s = new Stack<>();
                s.push(dest);
                map.put(src, s);
            } else {
                map.get(src).push(dest);
            }
        }

        for (int i = 0; i + 1 < arr2.length; i += 2) {
            int src = arr2[i];
            int dest = arr2[i + 1];

            if (!map.containsKey(src) || map.get(src).peek() != dest) {
                return 0;
            }

            map.get(src).pop();
        }

        return 1;
    }
}
