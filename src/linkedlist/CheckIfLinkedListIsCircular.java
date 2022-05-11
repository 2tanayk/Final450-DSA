package linkedlist;

import java.util.*;

public class CheckIfLinkedListIsCircular {
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

        System.out.println(isCircular(head));
    }

    private static boolean isCircular(Node head) {
        if (head.next == null) {
            return false;
        }

        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return isLoopStartTheHead(head, slow, fast);
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    private static boolean isLoopStartTheHead(Node head, Node p1, Node p2) {
        p2 = p2.next;
        int ct = 1;

        while (p1 != p2) {
            ct++;
            p2 = p2.next;
        }

        Node cur = head;

        Node next = head;


        while (ct > 0) {
            ct--;
            next = next.next;
        }

        while (true) {
            if (cur == next) {
                return cur == head;
            }

            cur = cur.next;
            next = next.next;
        }
    }
}
