package greedy;

import java.util.*;

public class WaterConnection {
    private static class Pair {
        int b, d;

        public Pair(int b, int d) {
            this.b = b;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        ArrayList<Integer> a = new ArrayList<>(p);
        ArrayList<Integer> b = new ArrayList<>(p);
        ArrayList<Integer> d = new ArrayList<>(p);

        for (int i = 0; i < p; i++) {
            a.add(sc.nextInt());
        }

        for (int i = 0; i < p; i++) {
            b.add(sc.nextInt());
        }

        for (int i = 0; i < p; i++) {
            d.add(sc.nextInt());
        }

        System.out.println(installAndMinimize(n, p, a, b, d));
    }

    private static ArrayList<ArrayList<Integer>> installAndMinimize(int n, int p, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        HashSet<Integer> tankHouses = new HashSet<>();
        HashSet<Integer> tapHouses = new HashSet<>();

        HashMap<Integer, Pair> housePipeMap = new HashMap<>();

        for (int i = 0; i < p; i++) {
            int ai = a.get(i);
            int bi = b.get(i);
            int diameter = d.get(i);

            housePipeMap.put(ai, new Pair(bi, diameter));
        }

        for (int i = 0; i < p; i++) {
            int ai = a.get(i);
            int bi = b.get(i);
            if (tapHouses.contains(ai)) {
                tapHouses.remove(ai);
            } else {
                tankHouses.add(ai);
            }

            if (tankHouses.contains(bi)) {
                tankHouses.remove(bi);
            } else {
                tapHouses.add(bi);
            }
        }


        for (Integer tankH : tankHouses) {
            int key = tankH;
            int min = Integer.MAX_VALUE;
            ArrayList<Integer> tempList = new ArrayList<>();
            while (housePipeMap.size() > 0) {
                if (!housePipeMap.containsKey(key)) {
                    break;
                }
                Pair cur = housePipeMap.get(key);
                if (min > cur.d) {
                    min = cur.d;
                }

                if (tapHouses.contains(cur.b)) {
                    tempList.add(tankH);
                    tempList.add(cur.b);
                }
                housePipeMap.remove(key);
                key = cur.b;
            }
            tempList.add(min);
            ans.add(tempList);
        }
        return ans;
    }
}
