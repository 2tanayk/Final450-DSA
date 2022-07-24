package bitmanipulation;

import java.util.*;

public class CountSetBitsInFirstNNaturalNos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countSetBits(n));
    }

    public static int countSetBits(int n) {
        if (n == 0) {
            return 0;
        }

        int p = 0;

        while (Math.pow(2, p) <= n) {
            p++;
        }

        p--;

        return (int) Math.pow(2, p - 1) * p + (n - (int) Math.pow(2, p) + 1) + countSetBits(n - (int) Math.pow(2, p));
    }
}
