package stackandqueue;

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }


        String rev = "";

        while (!stack.empty()) {
            rev += stack.pop();
        }

        return rev;
    }
}
