package linkedlist;

import java.util.Scanner;

public class CheckIfLinkedListIsPalindrome {
    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter data for the head node:");
        int headData = sc.nextInt();
        Node head = new Node(headData, null);
        Node temp = head;

        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            temp.next = new Node(curData, null);
            temp = temp.next;
        }

        System.out.println(isPalindrome(head));
    }


    private static boolean isPalindrome(Node head) {
        int len = computeLLLength(head);
        Node cur = head;

        int ct;
        if (len % 2 == 0) {
            ct = len / 2 - 1;
        } else {
            ct = len / 2;
        }

        while (ct > 0) {
            cur = cur.next;
            ct--;
        }

        Node tail = reverse(cur, cur.next);

        if (len % 2 == 0) {
            ct = len / 2 - 1;
            while (ct >= 0) {
                if (head.data != tail.data) {
                    return false;
                }
                head = head.next;
                tail = tail.next;
                ct--;
            }
        } else {
            while (head != tail) {
                if (head.data != tail.data) {
                    return false;
                }

                head = head.next;
                tail = tail.next;
            }
        }

        return true;
    }


    private static Node reverse(Node prev, Node cur) {
        Node next = cur;

        while (next != null) {
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }


    private static int computeLLLength(Node cur) {
        int ct = 0;
        while (cur != null) {
            cur = cur.next;
            ct++;
        }
        return ct;
    }
}
