package linkedlist;

import java.util.*;

public class RemoveDuplicatesFromLinkedList {
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
            Node curNode = new Node(curData, null);
            temp.next = curNode;
            temp = temp.next;
        }

        printLinkedList(head);

        head = removeDuplicates(head);

        printLinkedList(head);
    }

    private static Node removeDuplicates(Node head) {
        if (head.next == null) {
            return head;
        }

        HashSet<Integer> seen = new HashSet<>();
        Node cur = head;
        seen.add(cur.data);

        while (cur.next != null) {
            if (seen.contains(cur.next.data)) {
                deleteNode(cur);
                continue;
            } else {
                seen.add(cur.next.data);
            }

            cur = cur.next;
        }

        return head;
    }

    private static void deleteNode(Node node) {
        node.next = node.next.next;
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
