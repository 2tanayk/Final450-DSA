package bitmanipulation;

import java.util.*;

public class CopySetBitsInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(setSetBit(x, y, l, r));
    }

    static int setSetBit(int x, int y, int l, int r) {
        int mask1 = (int) ((1L << r - l + 1) - 1 << l - 1);

        int mask2 = y & mask1;

        return x | mask2;
    }
}
