package linkedlist;

import java.util.*;

public class SortKSortedDoublyLinkedList {
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

        System.out.println(sortedDll(head, k));
    }

    private static Node sortedDll(Node head, int k) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        Node newHead = null, cur = null;
        int ct = k + 1;

        while (ct-- > 0) {
            minQ.add(head.data);
            head = head.next;
        }

        while (head != null) {
            if (newHead == null) {
                newHead = new Node(minQ.poll());
                cur = newHead;
            } else {
                Node temp = new Node(minQ.poll());
                temp.prev = cur;
                cur.next = temp;
                cur = cur.next;
            }

            minQ.add(head.data);
            head = head.next;
        }

        while (!minQ.isEmpty()) {
            Node temp = new Node(minQ.poll());
            temp.prev = cur;
            cur.next = temp;
            cur = cur.next;
        }

        return newHead;
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
