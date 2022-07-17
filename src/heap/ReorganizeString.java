package heap;

import java.util.*;

public class ReorganizeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();

        HashMap<Character, Integer> fm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            fm.put(c, fm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> fm.get(c2) - fm.get(c1));

        pq.addAll(fm.keySet());

        while (pq.size() > 1) {
            char c1 = pq.poll();
            char c2 = pq.poll();

            fm.put(c1, fm.get(c1) - 1);
            fm.put(c2, fm.get(c2) - 1);

            ans.append(c1);
            ans.append(c2);

            if (fm.get(c1) > 0) {
                pq.add(c1);
            }

            if (fm.get(c2) > 0) {
                pq.add(c2);
            }
        }

        if (pq.size() == 1) {
            char c = pq.poll();

            if (fm.get(c) > 1) {
                return "";
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
