package bst;

import java.util.*;

public class DeleteValueInBST {
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

        delete(root, val);
    }

    private static Node delete(Node root, int val) {
        if (root == null) {
            return root;
        }

        if (val == root.data) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {

                Node succParent = root;
                Node inSucc = root.right;

                while (inSucc.left != null) {
                    succParent = inSucc;
                    inSucc = inSucc.left;
                }

                root.data = inSucc.data;

                if (succParent != root) {
                    succParent.left = inSucc.right;
                } else {
                    succParent.right = inSucc.right;
                }
            }
        } else if (val < root.data) {
            root.left = delete(root.left, val);
        } else {
            root.right = delete(root.right, val);
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
