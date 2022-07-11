package graph;

import java.util.*;

public class CheapestFlightsWithinKStops {
    static class Node {
        int vertex, value, stops;

        Node(int vertex, int value, int stops) {
            this.vertex = vertex;
            this.value = value;
            this.stops = stops;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        int nE = sc.nextInt();

        int[][] flights = new int[nE][3];

        for (int i = 0; i < nE; i++) {
            flights[i][0] = sc.nextInt();
            flights[i][1] = sc.nextInt();
            flights[i][2] = sc.nextInt();
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(findCheapestPrice(nV, flights, src, dest, k));
    }

    public static int findCheapestPrice(int nV, int[][] flights, int src, int dest, int k) {
        int nE = flights.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>(nV);

        for (int i = 0; i < nV; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < nE; i++) {
            adj.get(flights[i][0]).add(flights[i]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.value != n2.value ? n1.value - n2.value : n1.stops - n2.stops);

        int[] dist = new int[nV];
        int[] stops = new int[nV];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);

        dist[src] = 0;
        stops[src] = -1;

        pq.add(new Node(src, 0, -1));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int curNode = cur.vertex;
            int curDist = cur.value;
            int curStops = cur.stops;

            if (curStops > k) {
                continue;
            }

            if (curNode == dest) {
                return cur.value;
            }

            for (int[] e : adj.get(curNode)) {
                int nextNode = e[1];
                int wt = e[2];

                int nextDist = curDist + wt;
                int nextStops = curStops + 1;

                if (nextDist < dist[nextNode] || nextStops < stops[nextNode]) {
                    dist[nextNode] = nextDist;
                    stops[nextNode] = nextStops;
                    pq.add(new Node(nextNode, nextDist, nextStops));
                }
            }
        }

        return -1;
    }
}
