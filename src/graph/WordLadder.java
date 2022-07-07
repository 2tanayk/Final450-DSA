package graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String begin = sc.nextLine();
        String end = sc.nextLine();

        int n = sc.nextInt();
        sc.nextLine();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            words.set(i, sc.nextLine());
        }

        System.out.println(ladderLength(begin, end, words));
    }

    public static int ladderLength(String begin, String end, List<String> words) {

        HashSet<String> wSet = new HashSet<>(words);

        if (!wSet.contains(end)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(begin);

        int depth = 0;

        while (!q.isEmpty()) {
            int breadth = q.size();
            depth += 1;
            while (breadth-- > 0) {
                String cur = q.poll();
                for (int i = 0; i < cur.length(); i++) {
                    char[] temp = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        temp[i] = c;
                        String newStr = String.valueOf(temp);

                        if (newStr.equals(cur)) {
                            continue;
                        } else if (newStr.equals(end)) {
                            return depth + 1;
                        } else if (wSet.contains(newStr)) {
                            q.add(newStr);
                            wSet.remove(newStr);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
