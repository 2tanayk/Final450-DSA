package linkedlist;

import java.util.*;

public class DeletionAndReverseInCircularLL {
    private static final Scanner sc = new Scanner(System.in);

    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter data for the head node 1:");
        int headData = sc.nextInt();
        Node head = new Node(headData, null);
        createCircularLinkedList(head);

        int n = sc.nextInt();

        head = deleteNode(head, n);
        head = reverse(head);
    }

    private static Node reverse(Node head) {
        if (head.next == head) {
            return head;
        }

        Node prev = null, cur = head, next = head.next;
        while (next != head) {
            prev = cur;
            cur = next;
            next = next.next;
            cur.next = prev;
        }
        next.next = cur;

        return cur;
    }

    private static Node deleteNode(Node head, int val) {
        if (head.next == head) {
            head.next = null;
            head = null;
            return head;
        }

        if (head.data == val) {
            Node cur = head;
            while (cur.next != head) {
                cur = cur.next;
            }
            cur.next = head.next;
            head = cur.next;

            return head;
        }

        Node prev = null, cur = head;

        while (cur.data != val) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        cur.next = null;

        return head;
    }

    private static void createCircularLinkedList(Node head) {
        Node cur = head;
        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            cur.next = new Node(curData, null);
            cur = cur.next;
        }
        cur.next = head;
    }
}
