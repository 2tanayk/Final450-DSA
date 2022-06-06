package stackandqueue;

import java.util.*;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(evaluatePostFix(s));
    }

    private static int evaluatePostFix(String str) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                s.push((int) ch - 48);
            } else {
                int b = s.pop();
                int a = s.pop();

                if (ch == '+') {
                    s.push(a + b);
                } else if (ch == '-') {
                    s.push(a - b);
                } else if (ch == '*') {
                    s.push(a * b);
                } else {
                    s.push(a / b);
                }
            }
        }

        return s.pop();
    }
}
