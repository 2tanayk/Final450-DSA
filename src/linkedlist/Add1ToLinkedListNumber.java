package linkedlist;

import java.util.*;

public class Add1ToLinkedListNumber {
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

        printLinkedList(head);

        head = addOne(head);

        printLinkedList(head);
    }

    public static Node addOne(Node head) {
        int carry = traverseAndAdd(head);

        if (carry > 0) {
            Node node = new Node(carry, null);
            node.next = head;
            head = node;
        }

        return head;
    }

    private static int traverseAndAdd(Node cur) {
        if (cur == null) {
            return 1;
        }

        int carry = traverseAndAdd(cur.next);

        int sum = cur.data + carry;

        cur.data = sum % 10;

        return sum / 10;
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
