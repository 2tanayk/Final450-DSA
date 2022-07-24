package bitmanipulation;

import java.util.*;

public class FindPositionOfOnlySetBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(findPosition(n));
    }

    private static int findPosition(int n) {
        if (n == 0 || (n & (n - 1)) != 0) {
            return -1;
        }

        return (int) (Math.log(n & ~(n - 1)) / Math.log(2)) + 1;
    }
}
