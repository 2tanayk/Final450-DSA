package dynamicprogramming;

import java.util.*;

public class EditDistance {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String init = sc.nextLine();
        String fin = sc.nextLine();

        System.out.println(editDistance(init, fin));
    }

    public static int editDistance(String s, String t) {
        if (s.equals(t)) {
            return 0;
        }

        int leni = s.length();
        int lenf = t.length();

        dp = new int[leni + 1][lenf + 1];

        for (int i = 0; i <= leni; i++) {
            Arrays.fill(dp[i], -1);
        }

        ArrayList<Character> iArr = new ArrayList<>();
        ArrayList<Character> fArr = new ArrayList<>();

        toList(s, iArr);
        toList(t, fArr);

        return minOps(iArr, leni, fArr, lenf);
    }

    private static int minOps(ArrayList<Character> ai, int leni, ArrayList<Character> af, int lenf) {
        if (leni == 0) {
            return lenf;
        }

        if (lenf == 0) {
            return leni;
        }

        if (dp[leni][lenf] != -1) {
            return dp[leni][lenf];
        }

        if (ai.get(leni - 1) == af.get(lenf - 1)) {
            dp[leni][lenf] = minOps(ai, leni - 1, af, lenf - 1);

            return dp[leni][lenf];
        }

        dp[leni][lenf] = 1 + Math.min(minOps(ai, leni, af, lenf - 1), Math.min(minOps(ai, leni - 1, af, lenf), minOps(ai, leni - 1, af, lenf - 1)));

        return dp[leni][lenf];
    }

    private static void toList(String s, ArrayList<Character> arr) {
        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }
    }
}
