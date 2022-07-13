package tree;

import java.util.*;

public class CheckIfSumTree {
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

        System.out.println(isSumTree(root));
    }

    private static boolean isSumTree(Node root) {
        return checkIfSumTree(root) != Integer.MIN_VALUE;
    }

    private static int checkIfSumTree(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }


        int val = node.data;

        int lVal = checkIfSumTree(node.left);
        int rVal = checkIfSumTree(node.right);

        if (lVal == Integer.MIN_VALUE || rVal == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (val != lVal + rVal) {
            return Integer.MIN_VALUE;
        }

        return val + lVal + rVal;
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
