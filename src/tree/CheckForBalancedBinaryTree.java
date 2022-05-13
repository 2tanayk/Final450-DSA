package tree;

import java.util.*;

public class CheckForBalancedBinaryTree {
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

        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(Node root) {
        return checkIfTreeIsBalanced(root, 0) != Integer.MIN_VALUE;
    }

    private static int checkIfTreeIsBalanced(Node root, int depth) {
        if (root == null) {
            return depth;
        }

        int lHeight = checkIfTreeIsBalanced(root.left, depth + 1);

        int rHeight = checkIfTreeIsBalanced(root.right, depth + 1);

        if (lHeight == Integer.MIN_VALUE || rHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int diff = Math.abs(lHeight - rHeight);

        if (diff > 1) {
            return Integer.MIN_VALUE;
        }

        return Math.max(lHeight, rHeight);
    }


    private static Node createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node rootNode = new Node(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
