package string;

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] s = str.toCharArray();
        System.out.println(Arrays.toString(s));
        printReverseString(s);
    }

    private static void printReverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }

        System.out.println(Arrays.toString(s));
    }
}
