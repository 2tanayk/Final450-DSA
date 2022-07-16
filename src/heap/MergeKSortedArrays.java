package heap;

import java.util.*;

public class MergeKSortedArrays {
    static class Element {
        int val, pos, aPos;

        Element(int val, int pos, int aPos) {
            this.val = val;
            this.pos = pos;
            this.aPos = aPos;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int[][] arr = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(mergeKArrays(arr, k));
    }

    private static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);

        for (int i = 0; i < k; i++) {
            pq.add(new Element(arr[i][0], 0, i));
        }

        while (!pq.isEmpty()) {
            Element cur = pq.poll();

            int curVal = cur.val;
            int curPos = cur.pos;
            int curAPos = cur.aPos;

            ans.add(curVal);

            if (curPos + 1 < arr[curAPos].length) {
                pq.add(new Element(arr[curAPos][curPos + 1], curPos + 1, curAPos));
            }

        }

        return ans;
    }
}
