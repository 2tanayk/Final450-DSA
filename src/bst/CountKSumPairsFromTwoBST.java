package bst;

import java.util.*;

public class CountKSumPairsFromTwoBST {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root1 = createBinaryTree();
        Node root2 = createBinaryTree();

        int k = sc.nextInt();

        System.out.println(countPairs(root1, root2, k));
    }

    public static int countPairs(Node root1, Node root2, int target) {
        if (root1 == null || root2 == null) {
            return 0;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        int ct = 0;

        while (true) {
            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                s2.push(root2);
                root2 = root2.right;
            }

            if (s1.empty() || s2.empty()) {
                break;
            }

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            int sum = top1.data + top2.data;

            if (sum == target) {
                ct++;
                s1.pop();
                s2.pop();

                root1 = top1.right;
                root2 = top2.left;

            } else if (sum > target) {
                s2.pop();

                root2 = top2.left;
            } else {
                s1.pop();

                root1 = top1.right;
            }
        }

        return ct;
    }

    private static Node createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) return null;

        Node rootNode = new Node(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
