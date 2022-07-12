package linkedlist;

import java.util.*;

public class RightRotateDoublyLinkedList {
    public static final Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int headData = sc.nextInt();

        Node head = new Node(headData);

        createDoublyLinkedList(head);

        int k = sc.nextInt();

        System.out.println(rotateDLL(head, k));
    }

    private static Node rotateDLL(Node head, int k) {
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (k-- > 0) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            temp.prev = tail;
            tail.next = temp;
            tail = tail.next;
        }

        head.prev = null;

        return head;
    }

    private static void createDoublyLinkedList(Node cur) {
        while (true) {
            int data = sc.nextInt();
            if (data == -1) {
                return;
            }
            Node node = new Node(data);
            node.prev = cur;
            cur.next = node;
            cur = cur.next;
        }
    }
}
