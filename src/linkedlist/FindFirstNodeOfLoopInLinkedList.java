package linkedlist;

import java.util.*;

public class FindFirstNodeOfLoopInLinkedList {
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
        Node node = findFirstOfLoop(head);

        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("-1");
        }
    }

    private static Node findFirstOfLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head, fast = head.next;
        int len = -1;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                len = computeLoopLength(slow, fast);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (len != -1) {
            Node cur = head;
            Node next = head;

            while (len > 0) {
                next = next.next;
                len--;
            }

            while (cur != next) {
                cur = cur.next;
                next = next.next;
            }

            return cur;
        }

        return null;
    }

    private static int computeLoopLength(Node p1, Node p2) {
        int ct = 1;
        p2 = p2.next;

        while (p1 != p2) {
            p2 = p2.next;
            ct++;
        }

        return ct;
    }
}
