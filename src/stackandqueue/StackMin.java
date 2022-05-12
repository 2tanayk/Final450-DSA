package stackandqueue;

import java.util.*;

public class StackMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int ch;
        do {
            ch = sc.nextInt();
            int x;
            switch (ch) {
                case 1:
                    x = sc.nextInt();
                    push(x, stack);
                    break;
                case 2:
                    System.out.println(pop(stack));
                    break;
                case 3:
                    System.out.println(isEmpty(stack));
                    break;
                case 4:
                    int n = sc.nextInt();
                    System.out.println(isFull(stack, n));
                    break;
                case 5:
                    System.out.println(min(stack));
                    break;
                case 6:
                    System.out.println(".");
                    break;
                default:
                    System.out.println("Incorrect input.");
            }
        } while (ch != 6);
    }

    public static void push(int a, Stack<Integer> s) {
        s.push(a);
    }

    public static int pop(Stack<Integer> s) {
        return s.pop();
    }

    public static int min(Stack<Integer> s) {
        int min = s.pop();
        while (!s.empty()) {
            min = Math.min(min, s.pop());
        }

        return min;
    }

    public static boolean isFull(Stack<Integer> s, int n) {
        return s.size() >= n;
    }

    public static boolean isEmpty(Stack<Integer> s) {
        return s.empty();
    }
}
