package bst;

import java.util.*;

public class SearchValueInBST {
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

        int val = sc.nextInt();

        System.out.println(search(root, val));
    }

    private static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            return true;
        }

        if (val < root.data) {
            return search(root.left, val);
        }

        return search(root.right, val);
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
