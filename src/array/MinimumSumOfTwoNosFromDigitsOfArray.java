package array;

import java.util.*;

public class MinimumSumOfTwoNosFromDigitsOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr, n));
    }

    private static String solve(int[] arr, int n) {
        if (n == 1) {
            return arr[0] + "";
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        Arrays.sort(arr);

        int i = 0, j;

        while (i < n) {
            s1.append(arr[i++]);
            if (i >= n) {
                break;
            }
            s2.append(arr[i++]);
        }

        while (s1.charAt(0) == '0') {
            s1.deleteCharAt(0);
        }

        while (s2.charAt(0) == '0') {
            s2.deleteCharAt(0);
        }

        String num1 = s1.toString();
        String num2 = s2.toString();
        StringBuilder ans = new StringBuilder();

        int carry = 0;

        i = num1.length() - 1;
        j = num2.length() - 1;

        while (i >= 0 && j >= 0) {
            int d1 = num1.charAt(i--) - '0';
            int d2 = num2.charAt(j--) - '0';

            int s = d1 + d2 + carry;

            ans.insert(0, s % 10);
            carry = s / 10;
        }

        while (i >= 0) {
            int d1 = num1.charAt(i--) - '0';
            int s = d1 + carry;

            ans.insert(0, s % 10);
            carry = s / 10;
        }

        while (j >= 0) {
            int d2 = num2.charAt(j--) - '0';
            int s = d2 + carry;

            ans.insert(0, s % 10);
            carry = s / 10;
        }

        if (carry > 0) {
            ans.insert(0, carry);
        }

        return ans.toString();
    }
}
