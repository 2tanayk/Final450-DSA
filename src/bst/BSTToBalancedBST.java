package bst;

import java.util.*;

public class BSTToBalancedBST {
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

        buildBalancedTree(root);
    }

    private static Node buildBalancedTree(Node root) {
        ArrayList<Integer> in = new ArrayList<>();

        inorder(root, in);

        return toBalancedBST(0, in.size() - 1, in);
    }

    private static Node toBalancedBST(int l, int h, ArrayList<Integer> in) {
        if (l > h) {
            return null;
        }

        if (l == h) {
            return new Node(in.get(l));
        }

        int mid = (l + h) / 2;
        Node node = new Node(in.get(mid));

        node.left = toBalancedBST(l, mid - 1, in);
        node.right = toBalancedBST(mid + 1, h, in);

        return node;
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
