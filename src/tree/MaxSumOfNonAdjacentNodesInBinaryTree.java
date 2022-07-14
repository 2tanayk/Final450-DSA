package tree;

import java.util.*;

public class MaxSumOfNonAdjacentNodesInBinaryTree {
    private static final Scanner sc = new Scanner(System.in);
    static HashMap<Node, Integer> mem = new HashMap<>();

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        System.out.println(getMaxSum(root));
    }

    private static int getMaxSum(Node root) {
        if (root == null) {
            return 0;
        }

        if (mem.containsKey(root)) {
            return mem.get(root);
        }

        int eSum = root.data;

        if (root.left != null) {
            eSum += getMaxSum(root.left.left);
            eSum += getMaxSum(root.left.right);
        }
        if (root.right != null) {
            eSum += getMaxSum(root.right.left);
            eSum += getMaxSum(root.right.right);
        }

        int oSum = getMaxSum(root.left) + getMaxSum(root.right);

        mem.put(root, Math.max(eSum, oSum));

        return mem.get(root);
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
