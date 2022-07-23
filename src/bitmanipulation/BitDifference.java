package bitmanipulation;

import java.util.*;

public class BitDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(countBitsFlip(a, b));
    }

    public static int countBitsFlip(int a, int b) {
        return countSetBits(a ^ b);
    }

    private static int countSetBits(int n) {
        int ct = 0;

        while (n > 0) {
            n &= n - 1;
            ct++;
        }

        return ct;
    }
}
