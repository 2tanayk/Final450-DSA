package bst;

import java.util.*;

public class MedianOfBST {
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

        System.out.println(findMedian(root));
    }

    static int ct = 0;

    public static float findMedian(Node root) {
        int n = countNodes(root);
        ct = 0;
        return n % 2 != 0 ? inorder(root, (n + 1) / 2) : (inorder(root, n / 2) + inorder(root, n / 2 + 1)) / 2.0f;
    }

    private static float inorder(Node node, int k) {
        if (node == null) {
            return Float.MIN_VALUE;
        }

        float ans = inorder(node.left, k);

        if (ans != Float.MIN_VALUE) {
            return ans;
        }

        ct++;

        if (ct == k) {
            ct = 0;
            return node.data;
        }

        ans = inorder(node.right, k);

        return ans;
    }

    private static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }

        int lCt = countNodes(node.left);
        int rCt = countNodes(node.right);

        return lCt + rCt + 1;
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
