package dynamicprogramming;

import java.util.*;

public class MaxDifferenceOfZerosAndOnesInBinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(maxSubstring(s));
    }

    private static int maxSubstring(String s) {
        int n = s.length();

        int diff = 0, max = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '1') {
                diff--;
            } else {
                diff++;
            }

            max = Math.max(max, diff);

            if (diff < 0) {
                diff = 0;
            }
        }

        return max;
    }
}
