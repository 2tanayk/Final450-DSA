package linkedlist;

import java.util.*;

public class SplitCircularLinkedListIntoTwo {
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

        Node[] ans = splitList(head);
        printLinkedList(ans[0]);
        printLinkedList(ans[1]);
    }

    private static Node[] splitList(Node head) {
        int size = computeLLSize(head, head);

        int partn;
        if (size % 2 == 0) {
            partn = size / 2 - 1;
        } else {
            partn = size / 2;
        }

        Node cur = head;
        int ct = 1;
        while (ct <= partn) {
            cur = cur.next;
            ct++;
        }

        Node head1 = head;
        Node head2 = cur.next;

        Node temp = cur.next;
        cur.next = head;
        cur = temp;

        while (ct < size - 1) {
            cur = cur.next;
            ct++;
        }

        cur.next = temp;

        return new Node[]{head1, head2};
    }


    private static int computeLLSize(Node p1, Node p2) {
        p2 = p2.next;
        int ct = 1;

        while (p1 != p2) {
            ct++;
            p2 = p2.next;
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
