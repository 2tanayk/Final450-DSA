package bst;

import java.util.*;

public class LowestCommonAncestorOfBST {
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

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(Objects.requireNonNull(LCA(root, n1, n2)).data);
    }

    private static Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (n1 < root.data && n2 < root.data) {
            return LCA(root.left, n1, n2);
        }

        if (n1 > root.data && n2 > root.data) {
            return LCA(root.right, n1, n2);
        }

        return root;
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
