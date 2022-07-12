package graph;

import java.util.*;

public class MinEdgesToReverseForPathFromSrcToDest {
    static class Pair {
        int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(nE);

        for (int i = 0; i < nE; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(u, v));

            edges.add(temp);
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(reverseEdges(nV, start, end, edges));
    }

    public static int reverseEdges(int nV, int start, int end, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < nV; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);

            adj.get(src).add(new Pair(dest, 0));
            adj.get(dest).add(new Pair(src, 1));
        }

        PriorityQueue<Pair> minQ = new PriorityQueue<>((n1, n2) -> n1.wt - n2.wt);

        boolean[] vis = new boolean[nV];
        int[] dist = new int[nV];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        minQ.add(new Pair(start, 0));

        while (!minQ.isEmpty()) {
            Pair cur = minQ.poll();
            int curNode = cur.v;
            int curDist = cur.wt;

            if (vis[curNode]) {
                continue;
            }

            if (curNode == end) {
                return curDist;
            }

            vis[curNode] = true;

            for (Pair p : adj.get(curNode)) {
                int nextNode = p.v;
                int wt = p.wt;

                int nextDist = curDist + wt;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    minQ.add(new Pair(nextNode, nextDist));
                }
            }
        }

        return -1;
    }
}
