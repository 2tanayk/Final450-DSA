package tree;

import java.util.Scanner;

public class MirrorOfBinaryTree {
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
        System.out.println("In-order traversal:");
        inorderTraversal(root);
        System.out.println();

        System.out.println("Mirroring the Binary Tree");
        mirrorBinaryTree(root);

        System.out.println("In-order traversal:");
        inorderTraversal(root);
    }

    private static void mirrorBinaryTree(Node root) {
        if (root == null) {
            return;
        }
        Node tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }

    private static void inorderTraversal(Node rootNode) {
        if (rootNode == null) return;

        inorderTraversal(rootNode.left);
        System.out.print(rootNode.data + " ");
        inorderTraversal(rootNode.right);
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
