package string;

import java.util.*;

public class SmallestWindowContainingAllCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String p = sc.nextLine();

        System.out.println(smallestWindow(s, p));
    }

    private static String smallestWindow(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (m > n) {
            return "-1";
        }

        if (m == n) {
            return s.equals(p) ? p : "-1";
        }

        HashMap<Character, Integer> pm = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char ch = p.charAt(i);
            pm.put(ch, pm.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, ctz = 0;
        int st = -1, e = -1, min = Integer.MAX_VALUE;

        while (j < n) {
            char cj = s.charAt(j);

            if (pm.containsKey(cj)) {
                int count = pm.get(cj) - 1;
                pm.put(cj, count);
                if (count == 0) {
                    ctz++;
                }
            }

            while (ctz == pm.size()) {
                if (min > j - i) {
                    min = j - i;
                    st = i;
                    e = j;
                }

                char ci = s.charAt(i);

                if (pm.containsKey(ci)) {
                    int count = pm.get(ci) + 1;
                    pm.put(ci, count);
                    if (count > 0) {
                        ctz--;
                    }
                }

                i++;
            }

            j++;
        }

        if (st == -1) {
            return "-1";
        }
        return s.substring(st, e + 1);
    }
}
