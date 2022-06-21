package linkedlist;

import java.util.*;

public class ReversingADoublyLinkedList {
    private static final Scanner sc = new Scanner(System.in);

    private static class Node {
        int data;
        Node next, prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {

        int headData = sc.nextInt();
        Node head = new Node(headData, null, null);
        createLinkedList(head);

        head = reverseDLL(head);

        printLinkedList(head);
    }

    public static Node reverseDLL(Node head) {
        Node cur = head, next = head, prev = null;

        while (next != null) {
            next = next.next;

            Node temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;

            prev = cur;

            cur = next;

        }

        return prev;
    }

    private static void createLinkedList(Node cur) {
        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }

            cur.next = new Node(curData, null, cur);
            cur = cur.next;
        }
    }

    private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
