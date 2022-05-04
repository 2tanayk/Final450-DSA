package linkedlist;

import java.util.*;

public class DetectCycleInLinkedList {
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

        System.out.println(detectLoop(head));
    }

    private static boolean detectLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
