package greedy;

import java.util.*;

public class RearrangeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(rearrangeCharacters(str));
    }

    private static String rearrangeCharacters(String str) {
        int len = str.length();
        StringBuilder ans = new StringBuilder();

        HashMap<Character, Integer> fm = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            fm.put(ch, fm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxRec = new PriorityQueue<>((c1, c2) -> fm.get(c2) - fm.get(c1));

        maxRec.addAll(fm.keySet());

        while (maxRec.size() > 1) {
            char cur = maxRec.poll();
            char next = maxRec.poll();

            ans.append(cur);
            ans.append(next);

            fm.put(cur, fm.get(cur) - 1);
            fm.put(next, fm.get(next) - 1);

            if (fm.get(cur) > 0) {
                maxRec.add(cur);
            }

            if (fm.get(next) > 0) {
                maxRec.add(next);
            }
        }

        if (!maxRec.isEmpty()) {
            char ch = maxRec.poll();

            if (fm.get(ch) > 1) {
                return "-1";
            }

            ans.append(ch);
        }

        return ans.toString();
    }
}
