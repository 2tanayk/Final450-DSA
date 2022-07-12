package linkedlist;

import java.util.*;

public class FindPairWithGivenSum {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int headData = sc.nextInt();

        Node head = new Node(headData);

        createDoublyLinkedList(head);

        int sum = sc.nextInt();

        System.out.println(findPairsWithGivenSum(sum, head));
    }

    private static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Node i = head;
        Node j = head;

        while (j.next != null) {
            j = j.next;
        }

        while (i.data < j.data) {
            int x = i.data;
            int y = j.data;
            int sum = x + y;
            if (sum == target) {
                ans.add(new ArrayList<>(Arrays.asList(x, y)));
                i = i.next;
                j = j.prev;
            } else if (sum > target) {
                j = j.prev;
            } else {
                i = i.next;
            }
        }

        return ans;
    }

    private static void createDoublyLinkedList(Node cur) {
        while (true) {
            int data = sc.nextInt();
            if (data == -1) {
                return;
            }
            Node node = new Node(data);
            node.prev = cur;
            cur.next = node;
            cur = cur.next;
        }
    }
}
