package bst;

import java.util.*;

public class PopulateInorderSuccessor {
    private static final Scanner sc = new Scanner(System.in);
    static Node next = null;

    static class Node {
        Node left, right, next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        populateNext(root);
    }

    private static void populateNext(Node node) {
        if (node == null) {
            return;
        }

        populateNext(node.right);
        node.next = next;
        next = node;
        populateNext(node.left);
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
