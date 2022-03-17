package trees;

import java.util.Scanner;

public class DiameterOfBinaryTree {
    private static final Scanner sc = new Scanner(System.in);
    private static int max = 0;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(max);
    }

    private static int diameterOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        int hl = diameterOfBinaryTree(root.left);
        int hr = diameterOfBinaryTree(root.right);
        max = Math.max(max, hl + hr + 1);

        return 1 + Math.max(hl, hr);
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
