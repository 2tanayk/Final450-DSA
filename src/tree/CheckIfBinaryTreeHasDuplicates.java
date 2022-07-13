package tree;

import java.util.*;

public class CheckIfBinaryTreeHasDuplicates {
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

        System.out.println(dupSub(root));
    }

    private static int dupSub(Node root) {
        HashSet<String> hs = new HashSet<>();

        return hasDuplicateSubtree(root, "", hs).equals("F") ? 1 : 0;
    }

    private static String hasDuplicateSubtree(Node node, String s, HashSet<String> hs) {
        if (node == null) {
            return "$";
        }

        if (node.left == null && node.right == null) {
            return node.data + "*";
        }

        String sub = node.data + "*";

        String lTree = hasDuplicateSubtree(node.left, s, hs);

        if (lTree.equals("F")) {
            return "F";
        }

        sub = lTree + sub;

        String rTree = hasDuplicateSubtree(node.right, s, hs);

        if (rTree.equals("F")) {
            return "F";
        }

        sub = sub + rTree;

        if (hs.contains(sub)) {
            return "F";
        } else {
            hs.add(sub);
        }

        return sub + "*";
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
