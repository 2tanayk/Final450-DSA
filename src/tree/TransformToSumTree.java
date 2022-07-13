package tree;

import java.util.*;

public class TransformToSumTree {
    private static final Scanner sc = new Scanner(System.in);
    private static Node prev = null, head = null;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        toSumTree(root);
    }

    private static void toSumTree(Node root) {
        createSumTree(root);
    }

    private static int createSumTree(Node node) {
        if (node == null) {
            return 0;
        }

        int val = node.data;

        int lVal = createSumTree(node.left);
        int rVal = createSumTree(node.right);

        node.data = lVal + rVal;

        return node.data + val;
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
