package arrays;

import java.util.Scanner;

public class PalindromicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(isArrayPalindrome(arr, n) == 1 ? "Yes" : "No");
        }
    }

    private static int isArrayPalindrome(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (!isNumberPalindrome(arr[i])) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean isNumberPalindrome(int n) {
        int org = n;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return org == rev;
    }
}
