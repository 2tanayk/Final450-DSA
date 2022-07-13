package tree;

import java.util.*;

public class CheckIfAllLeafNodesHaveSameLevel {
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

        System.out.println(check(root));
    }

    private static boolean check(Node root) {
        return checkLeafLevel(root, 0) != Integer.MIN_VALUE;
    }

    private static int checkLeafLevel(Node node, int lvl) {
        if (node.left == null && node.right == null) {
            return lvl;
        }

        int lLvl = -1;
        if (node.left != null) {
            lLvl = checkLeafLevel(node.left, lvl + 1);
        }

        int rLvl = -1;

        if (node.right != null) {
            rLvl = checkLeafLevel(node.right, lvl + 1);
        }

        if (lLvl != -1 && rLvl != -1 && lLvl != rLvl) {
            return Integer.MIN_VALUE;
        }

        return lLvl == -1 ? rLvl : lLvl;
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
