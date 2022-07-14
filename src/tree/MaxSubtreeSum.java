package tree;

import java.util.*;

public class MaxSubtreeSum {
    private static final Scanner sc = new Scanner(System.in);

    public static int maxSum = Integer.MIN_VALUE;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        findMaxSubtreeSum(root);

        System.out.println(maxSum);
    }

    private static int findMaxSubtreeSum(Node node) {
        if (node == null) {
            return 0;
        }

        int sum = node.data;
        sum += findMaxSubtreeSum(node.left);
        sum += findMaxSubtreeSum(node.right);

        maxSum = Math.max(maxSum, sum);

        return sum;
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
