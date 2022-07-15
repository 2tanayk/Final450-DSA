package bst;

import java.util.*;

public class KthLargestElementInBST {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        int k = sc.nextInt();

        System.out.println(kthLargest(root, k));
    }

    static int ct = 0;

    public static int kthLargest(Node root, int k) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int ans = kthLargest(root.right, k);

        if (ans != Integer.MAX_VALUE) {
            return ans;
        }

        ct++;

        if (ct == k) {
            //bcoz static variables retain their values from old test cases
            ct = 0;
            return root.data;
        }

        ans = kthLargest(root.left, k);

        return ans;
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
