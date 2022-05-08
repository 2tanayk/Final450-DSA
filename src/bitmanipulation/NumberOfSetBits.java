package bitmanipulation;

import java.util.*;

public class NumberOfSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(setBits(n));
    }

    private static int setBits(int n) {
        int ct = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                ct++;
            }
            n /= 2;
        }

        return ct;
    }
}
