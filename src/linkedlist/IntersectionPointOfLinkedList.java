package linkedlist;

import java.util.*;

public class IntersectionPointOfLinkedList {
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
        Node cur1 = createLinkedList(head1);
        headData = sc.nextInt();
        System.out.println("Enter data for the head node 2:");
        Node head2 = new Node(headData, null);
        Node cur2 = createLinkedList(head2);

        System.out.println("Enter common nodes:");
        createCommon(cur1, cur2);

        System.out.println(intersectPoint(head1, head2));
    }

    private static int intersectPoint(Node head1, Node head2) {
        int len1 = linkedListLength(head1);
        int len2 = linkedListLength(head2);

        if (len2 > len1) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        Node cur1 = head1, cur2 = head2;
        int ct = Math.abs(len1 - len2);

        while (ct > 0) {
            cur1 = cur1.next;
            ct--;
        }

        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1.data;
            }

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return -1;
    }

    private static int linkedListLength(Node cur) {
        int ct = 0;

        while (cur != null) {
            ct++;
            cur = cur.next;
        }

        return ct;
    }

    private static void createCommon(Node cur1, Node cur2) {
        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            cur1.next = new Node(curData, null);
            cur1 = cur1.next;
            cur2.next = new Node(curData, null);
            cur2 = cur2.next;
        }
    }


    private static Node createLinkedList(Node cur) {
        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            cur.next = new Node(curData, null);
            cur = cur.next;
        }

        return cur;
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
