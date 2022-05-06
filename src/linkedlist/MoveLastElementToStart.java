package linkedlist;

import java.util.*;

public class MoveLastElementToStart {
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

        head = moveLastNodeToStart(head);

        printLinkedList(head);
    }

    private static Node moveLastNodeToStart(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;

        while (cur.next.next != null) {
            cur = cur.next;
        }

        Node temp = cur.next;
        cur.next = null;
        temp.next = head;

        return temp;
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
