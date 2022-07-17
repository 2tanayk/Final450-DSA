package heap;

import java.util.*;

public class MergeKSortedLinkedLists {
    private static final Scanner sc = new Scanner(System.in);

    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    static class Element {
        int data;
        Node node;

        Element(int data, Node node) {
            this.data = data;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            int headData = sc.nextInt();
            Node head = new Node(headData, null);
            createLinkedList(head);

            arr[i] = head;
        }

        Node newHead = mergeKList(arr, n);
    }

    private static Node mergeKList(Node[] arr, int k) {
        Node dummy = new Node(-1), head = dummy;

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e1.data - e2.data);

        for (int i = 0; i < k; i++) {
            pq.add(new Element(arr[i].data, arr[i]));
        }

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int data = e.data;
            Node cur = e.node;

            dummy.next = cur;

            if (cur.next != null) {
                pq.add(new Element(cur.next.data, cur.next));
            }

            dummy = dummy.next;
        }

        dummy.next = null;

        return head.next;
    }

    private static void createLinkedList(Node head) {
        Node cur = head;
        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            cur.next = new Node(curData, null);
            cur = cur.next;
        }
    }
}
