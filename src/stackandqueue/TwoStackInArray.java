package stackandqueue;

import java.util.*;

public class TwoStackInArray {

    private static class TwoStack {

        int size;
        int top1, top2;
        int[] arr = new int[100];

        TwoStack() {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoStack stack = new TwoStack();
        int ch;
        do {
            ch = sc.nextInt();
            int x;
            switch (ch) {
                case 1:
                    x = sc.nextInt();
                    push1(x, stack);
                    break;
                case 2:
                    System.out.println(pop1(stack));
                    break;
                case 3:
                    x = sc.nextInt();
                    push2(x, stack);
                    break;
                case 4:
                    System.out.println(pop2(stack));
                    break;
                case 5:
                    System.out.println(".");
                    break;
                default:
                    System.out.println("Incorrect input.");
            }
        } while (ch != 5);
    }

    private static void push1(int x, TwoStack sq) {
        if (sq.top1 + 1 < sq.top2) {
            sq.arr[++sq.top1] = x;
        }
    }


    private static void push2(int x, TwoStack sq) {
        if (sq.top1 < sq.top2 - 1) {
            sq.arr[--sq.top2] = x;
        }
    }


    private static int pop1(TwoStack sq) {
        if (sq.top1 != -1) {
            return sq.arr[sq.top1--];
        }
        return -1;
    }

    private static int pop2(TwoStack sq) {
        if (sq.top2 != sq.size) {
            return sq.arr[sq.top2++];
        }
        return -1;
    }
}
