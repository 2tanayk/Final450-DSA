package linkedlist;

import java.util.*;

public class MiddleOfLinkedList {
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
        createLinkedList(head);

        System.out.println(middleNode(head));
    }

    private static Node middleNode(Node head) {
        int mid = linkedListLength(head) / 2;

        while (mid > 0) {
            head = head.next;
            mid--;
        }

        return head;
    }

    private static int linkedListLength(Node cur) {
        int ct = 0;
        while (cur != null) {
            ct++;
            cur = cur.next;
        }

        return ct;
    }

    private static void createLinkedList(Node cur) {
        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            cur.next = new Node(curData, null);
            cur = cur.next;
        }
    }
}
