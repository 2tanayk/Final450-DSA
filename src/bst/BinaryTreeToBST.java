package bst;

import java.util.*;

public class BinaryTreeToBST {
    private static final Scanner sc = new Scanner(System.in);
    static int i;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        binaryTreeToBST(root);
    }

    private static Node binaryTreeToBST(Node root) {
        i = 0;
        ArrayList<Integer> in = new ArrayList<>();

        inorder(root, in);
        Collections.sort(in);

        toBST(root, in);

        return root;
    }

    private static void toBST(Node node, ArrayList<Integer> in) {
        if (node == null) {
            return;
        }

        toBST(node.left, in);
        node.data = in.get(i++);
        toBST(node.right, in);
    }

    private static void inorder(Node node, ArrayList<Integer> in) {
        if (node == null) {
            return;
        }

        inorder(node.left, in);
        in.add(node.data);
        inorder(node.right, in);
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
