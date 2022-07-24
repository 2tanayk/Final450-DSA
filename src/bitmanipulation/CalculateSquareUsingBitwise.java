package bitmanipulation;

import java.util.*;

public class CalculateSquareUsingBitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(calculateSquare(n));
    }

    public static int calculateSquare(int n) {
        n = Math.abs(n);
        int temp = n;
        int sq = 0;
        int pos = 0;
        while (temp > 0) {
            if ((temp & 1) > 0) {
                sq += n << pos;
            }

            pos++;
            temp >>= 1;
        }

        return sq;
    }
}
