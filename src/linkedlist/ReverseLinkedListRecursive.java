package linkedlist;

import java.util.*;

public class ReverseLinkedListRecursive {
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
            Node curNode = new Node(curData, null);
            temp.next = curNode;
            temp = temp.next;
        }

        printLinkedList(head);

        head = reverseLinkedList(head);

        printLinkedList(head);
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLinkedList(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
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
