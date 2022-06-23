package string;

import java.util.*;

public class CountAndSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countAndSay(n));
    }

    private static String countAndSay(int n) {
        String s = "1";

        for (int i = 2; i <= n; i++) {
            int len = s.length();
            StringBuilder temp = new StringBuilder();
            char prev = s.charAt(0);
            int ct = 1;

            for (int j = 1; j < len; j++) {
                char cur = s.charAt(j);

                if (cur == prev) {
                    ct++;
                } else {
                    temp.append(ct);
                    temp.append(prev);

                    ct = 1;
                    prev = cur;
                }
            }

            temp.append(ct);
            temp.append(prev);

            s = temp.toString();
        }

        return s;
    }
}