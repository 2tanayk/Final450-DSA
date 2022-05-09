package linkedlist;

import java.util.*;

public class AddTwoNumbers {
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

        System.out.println("Enter data for the head node 1:");
        int headData1 = sc.nextInt();
        Node head1 = new Node(headData1, null);
        Node temp = head1;

        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            temp.next = new Node(curData, null);
            temp = temp.next;
        }

        System.out.println("Enter data for the head node 2:");
        int headData2 = sc.nextInt();
        Node head2 = new Node(headData2, null);
        temp = head2;

        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            temp.next = new Node(curData, null);
            temp = temp.next;
        }


        printLinkedList(head1);

        head1 = addTwoLists(head1, head2);

        printLinkedList(head1);
    }

    private static Node addTwoLists(Node first, Node second) {
        int len1 = linkedListLength(first);
        int len2 = linkedListLength(second);

        if (len1 < len2) {
            Node temp = first;
            first = second;
            second = temp;
        }

        int carry = sum(first, second, Math.abs(len1 - len2) + 1, 1);

        if (carry > 0) {
            Node node = new Node(carry, null);
            node.next = first;
            first = node;
        }

        return first;
    }

    private static int sum(Node first, Node second, int chk, int ct) {
        if (first == null) {
            return 0;
        }

        int carry;
        int cSum;
        if (ct < chk) {
            carry = sum(first.next, second, chk, ct + 1);
            cSum = first.data + carry;
        } else {
            carry = sum(first.next, second.next, chk, ct + 1);
            cSum = first.data + second.data + carry;
        }

        first.data = cSum % 10;

        return cSum / 10;
    }

    private static int linkedListLength(Node cur) {
        int ct = 0;

        while (cur != null) {
            ct++;
            cur = cur.next;
        }

        return ct;
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
