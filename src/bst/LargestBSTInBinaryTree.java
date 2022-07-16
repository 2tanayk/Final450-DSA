package bst;

import java.util.*;

public class LargestBSTInBinaryTree {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static class NodeValue {
        int size, min, max;

        NodeValue(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        System.out.println(largestBst(root));
    }

    static int largestBst(Node root) {
        return largest(root).size;
    }

    private static NodeValue largest(Node node) {
        if (node == null) {
            return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeValue left = largest(node.left);
        NodeValue right = largest(node.right);

        if (left.max < node.data && right.min > node.data) {
            return new NodeValue(left.size + right.size + 1, Math.min(node.data, left.min), Math.max(node.data, right.max));
        }

        return new NodeValue(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
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
