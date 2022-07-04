package string;

import java.util.*;

public class SplitBinaryStringIntoBalancedSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(maxSubStr(s));
    }

    public static int maxSubStr(String str) {
        int len = str.length();
        if (len == 1) {
            return -1;
        }

        int ct = 0, ct1 = 0, ct0 = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (ch == '1') {
                ct1++;
            } else {
                ct0++;
            }

            if (ct0 == ct1 && ct0 > 0) {
                ct++;

                ct0 = 0;
                ct1 = 0;
            }
        }

        if (ct0 != ct1) {
            return -1;
        }

        return ct;
    }
}
