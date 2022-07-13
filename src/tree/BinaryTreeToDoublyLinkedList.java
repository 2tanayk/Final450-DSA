package tree;

import java.util.*;

public class BinaryTreeToDoublyLinkedList {
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

        System.out.println(bToDLL(root));
    }

    private static Node bToDLL(Node root) {
        convertToDLL(root);

        return head;
    }

    private static void convertToDLL(Node node) {
        if (node == null) {
            return;
        }

        convertToDLL(node.left);

        if (head == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }

        prev = node;

        convertToDLL(node.right);
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
