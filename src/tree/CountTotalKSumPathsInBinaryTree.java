package tree;

import java.util.*;

public class CountTotalKSumPathsInBinaryTree {
    private static final Scanner sc = new Scanner(System.in);
    static int ct;
    final static long m = (long) (Math.pow(10, 9) + 7);
    static HashMap<Integer, Integer> fm;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        int k = sc.nextInt();

        System.out.println(sumK(root, k));
    }

    public static int sumK(Node root, int k) {
        ct = 0;
        fm = new HashMap<>();
        fm.put(0, 1);

        countPaths(root, k, 0);

        return (int) ((long) ct % m);
    }

    private static void countPaths(Node node, int k, int sum) {
        if (node == null) {
            return;
        }

        sum += node.data;

        if (fm.containsKey(sum - k)) {
            ct = (int) (((long) ct + fm.get(sum - k)) % m);
        }

        fm.put(sum, fm.getOrDefault(sum, 0) + 1);
        countPaths(node.left, k, sum);
        countPaths(node.right, k, sum);

        fm.put(sum, fm.get(sum) - 1);
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
