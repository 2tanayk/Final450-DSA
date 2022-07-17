package heap;

import java.util.*;

public class SmallestRangeInKLists {
    static class Element {
        int val, pos, aPos;

        Element(int val, int pos, int aPos) {
            this.val = val;
            this.pos = pos;
            this.aPos = aPos;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "val=" + val +
                    ", pos=" + pos +
                    ", aPos=" + aPos +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[k][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(findSmallestRange(arr, n, k)));
    }

    private static int[] findSmallestRange(int[][] arr, int n, int k) {
        int max = Integer.MIN_VALUE, range = Integer.MAX_VALUE;

        int l = -1, h = -1;

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);

        for (int i = 0; i < k; i++) {
            pq.add(new Element(arr[i][0], 0, i));
            max = Math.max(max, arr[i][0]);
        }

        while (true) {
            Element cur = pq.poll();

            int pos = cur.pos;
            int aPos = cur.aPos;
            int curMin = cur.val;

            if (range > max - curMin) {
                range = max - curMin;
                l = curMin;
                h = max;
            }

            if (pos + 1 >= n) {
                break;
            }

            pq.add(new Element(arr[aPos][pos + 1], pos + 1, aPos));
            max = Math.max(max, arr[aPos][pos + 1]);
        }


        return new int[]{l, h};
    }

//    private static int[] findSmallestRange(int[][] arr, int n, int k) {
//        ArrayList<Element> mArr = new ArrayList<>();
//
//        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);
//
//        for (int i = 0; i < k; i++) {
////            System.out.println(arr[i][0]);
//            pq.add(new Element(arr[i][0], 0, i));
//        }
//
////        System.out.println(pq.peek());
//
//        while (!pq.isEmpty()) {
//            Element cur = pq.poll();
//
////            System.out.println(cur);
//
//            int curPos = cur.pos;
//            int curAPos = cur.aPos;
//
//            mArr.add(cur);
//
//            if (curPos + 1 < n) {
//                pq.add(new Element(arr[curAPos][curPos + 1], curPos + 1, curAPos));
//            }
//        }
//
////        System.out.println(mArr);
//
//        int i = 0, j = i + 1;
//        int size = mArr.size();
//        int minRange = 0;
//        int l = i, h = -1;
//
//        HashMap<Integer, Integer> pm = new HashMap<>();
//
//        pm.put(mArr.get(i).aPos, 1);
//
//        while (j < size) {
//            int aPos = mArr.get(j++).aPos;
//            pm.put(aPos, pm.getOrDefault(aPos, 0) + 1);
//
//            minRange++;
//
//            if (pm.size() == k) {
//                h = j - 1;
//                break;
//            }
//        }
//
//        System.out.println(l + " " + h);
//
//        if (h == -1) {
//            return new int[]{-1, -1};
//        }
//
//        while (i < j && j < size) {
//            while (pm.size() == k) {
//                int aPos = mArr.get(i++).aPos;
//
//                int f = pm.get(aPos) - 1;
//
//                if (f == 0) {
//                    if (h - l + 1 < minRange) {
//                        l = i - 1;
//                        minRange = h - l + 1;
//                    }
//                    pm.remove(aPos);
//                    continue;
//                }
//
//                pm.put(aPos, f);
//            }
//
//            int aPos = mArr.get(j++).aPos;
//            pm.put(aPos, pm.getOrDefault(aPos, 0) + 1);
//
//
//            if (pm.size() == k && j - i < minRange) {
//                l = i;
//                h = j - 1;
//                minRange = j - i;
//            }
//        }
//
//
//        return new int[]{l, h};
//    }
}
