package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LargeFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> factorialList = findLargeFactorial(n);

        for (Integer e : factorialList) {
            System.out.print(e);
        }
        System.out.println();
    }

    private static ArrayList<Integer> findLargeFactorial(int n) {
        ArrayList<Integer> factorialList = new ArrayList<>();
        factorialList.add(1);
        for (int i = 2; i <= n; i++) {
            multiply(factorialList, i);
        }

        Collections.reverse(factorialList);
        return factorialList;
    }

    private static void multiply(ArrayList<Integer> factorialList, int k) {
        int carry = 0;
        int i;
        for (i = 0; i < factorialList.size(); i++) {
            int digit = factorialList.get(i);
            int product = digit * k + carry;
            carry = product / 10;
            factorialList.set(i, product % 10);
        }

        while (carry > 0) {
            factorialList.add(i, carry % 10);
            carry /= 10;
            i++;
        }
    }
}
