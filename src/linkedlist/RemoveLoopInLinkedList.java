package linkedlist;

import java.util.*;

public class RemoveLoopInLinkedList {
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

        removeLoop(head);
    }

    private static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node cur = head;
        HashSet<Node> nodeSet = new HashSet<>();

        while (cur.next != null) {
            nodeSet.add(cur);
            if (nodeSet.contains(cur.next)) {
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
    }
}
