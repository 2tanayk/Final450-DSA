package linkedlist;

import java.util.*;

public class RemoveLoopInLinkedList {
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

        removeLoop(head);
    }

    private static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head, fast = head.next;
        int len = -1;


        while (fast != null && fast.next != null) {
            if (slow == fast) {
                len = computeLoopLength(slow, fast);
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }


        if (len != -1) {
            Node cur = head;
            Node next = head;
            int ct = len;

            while (ct > 0) {
                next = next.next;
                ct--;
            }

            while (cur != next) {
                cur = cur.next;
                next = next.next;
            }

            ct = len;
            while (ct > 1) {
                cur = cur.next;
                ct--;
            }

            cur.next = null;
        }
    }

    public static int computeLoopLength(Node p1, Node p2) {
        int ct = 1;
        p2 = p2.next;

        while (p1 != p2) {
            p2 = p2.next;
            ct++;
        }

        return ct;
    }
}
