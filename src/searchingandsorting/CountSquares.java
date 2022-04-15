package searchingandsorting;

import java.util.*;

public class CountSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(findSquaresLessThanN(n));
    }

    private static int findSquaresLessThanN(int n) {
        int ctSq = 0;

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (i * i < n) {
                ctSq++;
            }
        }
        return ctSq;
    }
}
