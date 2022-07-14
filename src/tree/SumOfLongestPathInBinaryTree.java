package tree;

import java.util.*;

public class SumOfLongestPathInBinaryTree {
    private static final Scanner sc = new Scanner(System.in);
    private static int maxLvl, maxSum;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        System.out.println(sumOfLongRootToLeafPath(root));
    }

    private static int sumOfLongRootToLeafPath(Node root) {
        maxLvl = -1;
        maxSum = Integer.MIN_VALUE;

        longestPathSum(root, 0, 0);

        return maxSum;
    }

    private static void longestPathSum(Node node, int sum, int lvl) {
        if (node == null) {
            return;
        }

        sum += node.data;

        if (lvl > maxLvl) {
            maxLvl = lvl;
            maxSum = sum;
        } else if (lvl == maxLvl && sum > maxSum) {
            maxSum = sum;
        }

        longestPathSum(node.left, sum, lvl + 1);
        longestPathSum(node.right, sum, lvl + 1);
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
