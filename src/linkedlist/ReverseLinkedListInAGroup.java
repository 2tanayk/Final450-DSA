package linkedlist;

import java.util.*;

public class ReverseLinkedListInAGroup {
    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private static class Triplet {
        Node first, last, lastNext;

        public Triplet(Node first, Node last, Node lastNext) {
            this.first = first;
            this.last = last;
            this.lastNext = lastNext;
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

        int k = sc.nextInt();

        head = reverse(head, k);

        printLinkedList(head);
    }

    public static Node reverse(Node node, int k) {
        if (node.next == null) {
            return node;
        }
        Node cur = node;
        int len = 0;

        while (cur != null) {
            cur = cur.next;
            len++;
        }

        int i = 0;
        Node head = null;
        Node prev = null;
        while (len > 0) {
            Triplet triplet;
            if (len > k) {
                len -= k;
                triplet = reverseGroup(node, k);
            } else {
                triplet = reverseGroup(node, len);
                len = 0;
            }
            if (prev != null) {
                prev.next = triplet.first;
            }

            prev = triplet.last;
            node = triplet.lastNext;

            if (i == 0) {
                head = triplet.first;
            }

            i++;
        }


        return head;
    }

    private static Triplet reverseGroup(Node start, int k) {
        Node last = start;

        Node prev = null, cur = start, next = start;

        while (k > 0) {
            next = next.next;
            if (prev != null) {
                cur.next = prev;
            }
            prev = cur;
            cur = next;
            k--;
        }

        if (cur == null) {
            last.next = null;
        }

        Node first = prev;

        return new Triplet(first, last, cur);
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
