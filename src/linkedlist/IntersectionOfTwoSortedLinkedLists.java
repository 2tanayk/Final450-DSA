package linkedlist;

import java.util.*;

public class IntersectionOfTwoSortedLinkedLists {
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
        Node head1 = new Node(headData, null);
        createLinkedList(head1);
        headData = sc.nextInt();
        System.out.println("Enter data for the head node 2:");
        Node head2 = new Node(headData, null);
        createLinkedList(head2);

        Node head = findIntersection(head1, head2);

        printLinkedList(head);
    }

    public static Node findIntersection(Node head1, Node head2) {
        Node cur1 = head1, cur2 = head2;
        Node head = new Node(-1, null);
        Node cur = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.data == cur2.data) {
                cur.next = new Node(cur1.data, null);
                cur = cur.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if (cur1.data > cur2.data) {
                cur2 = cur2.next;
            } else {
                cur1 = cur1.next;
            }
        }

        head = head.next;

        return head;
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

    private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
