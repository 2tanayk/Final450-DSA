package bst;

import java.util.*;

public class BSTFromPreorderTraversal {
    private static final Scanner sc = new Scanner(System.in);
    static int i = 0;

    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        int n = sc.nextInt();
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }

        bstFromPreorder(pre);
    }

    public static TreeNode bstFromPreorder(int[] pre) {

        return bst(pre, Integer.MAX_VALUE);
    }

    private static TreeNode bst(int[] pre, int bound) {
        if (i == pre.length || pre[i] > bound) {
            return null;
        }

        TreeNode node = new TreeNode(pre[i++]);
        node.left = bst(pre, node.val);
        node.right = bst(pre, bound);

        return node;
    }

    private static TreeNode createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) return null;

        TreeNode rootNode = new TreeNode(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
