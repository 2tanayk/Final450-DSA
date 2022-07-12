package linkedlist;

import java.util.*;

public class NthNodeFromEndOfLinkedList {
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

        int k = sc.nextInt();

        System.out.println(getNthFromLast(head, k));
    }

    private static int getNthFromLast(Node head, int k) {
        Node p1 = head, p2 = head;

        int ct = 0;

        while (ct < k - 1 && p2 != null) {
            p2 = p2.next;
            ct++;
        }

        if (p2 == null) {
            return -1;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.data;
    }
}
