package bst;

import java.util.*;

public class CheckIfBST {
    private static final Scanner sc = new Scanner(System.in);
    static int prev;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        System.out.println(isBST(root));
    }

    public static boolean isBST(Node root) {
        prev = Integer.MIN_VALUE;

        return inorderCheck(root);
    }

    public static boolean inorderCheck(Node node) {
        if (node == null) {
            return true;
        }

        boolean flag = inorderCheck(node.left);

        if (!flag) {
            return false;
        }


        if (prev >= node.data) {
            return false;
        } else {
            prev = node.data;
        }


        flag = inorderCheck(node.right);

        return flag;
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
